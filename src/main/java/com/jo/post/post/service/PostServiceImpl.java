package com.jo.post.post.service;

import com.jo.post.post.model.Category;
import com.jo.post.post.model.Post;
import com.jo.post.post.model.PostDto;
import com.jo.post.post.repository.PostRepository;
import com.jo.post.postImg.PostImgService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class PostServiceImpl implements PostService{

    private final PostRepository postRepository;
    private final PostImgService postImgService;

    Category saveCategory(Long categoryId) {
        Category category = null;
        if(categoryId == 1) { // 개인 목표 인증 카테고리
            category = Category.GOAL;
        } else if(categoryId == 2) { // 챌린지 인증 카테고리
            category = Category.CHALLENGE;
        }
        return category;
    }

    @Transactional
    @Override
    public Long savePost(PostDto postDto) {
        log.info("add Post");
        Post post = postRepository.save(Post.builder()
                .title(postDto.getTitle())
                .content(postDto.getContent())
                .category(saveCategory(postDto.getCategoryId()))
                .postImg(postDto.getPostImg())
                .created(LocalDate.now())
                .goalId(postDto.getGoalId())
                .userId(postDto.getUserId())
                .build());
        return post.getId();
//        if(postRepository.findByGoalIdAndCreated(postDto.getGoalId(), postDto.getCreated()).isPresent()) {
//            return null; // 해당 일에 이미 작성한 인증 글이 있는 경우
//        } else {
//            Post post = postRepository.save(Post.builder()
//                    .title(postDto.getTitle())
//                    .content(postDto.getContent())
//                    .category(saveCategory(postDto.getCategoryId()))
//                    .postImg(postDto.getPostImg())
//                    .created(LocalDate.now())
//                    .goalId(postDto.getGoalId())
//                    .userId(postDto.getUserId())
//                    .build());
//            return post.getId();
//        }
    }

    @Transactional
    @Override
    public List<Post> findAllPost() {
        return postRepository.findAll();
    }

    @Transactional
    @Override
    public Optional<Post> findById(Long id) {
        log.info("find by post id : {}", id);
        return Optional.ofNullable(postRepository.findById(id).get());
    }

    @Transactional
    @Override
    public int updateView(Long id) {
        log.info("update view : {}", id);
        return postRepository.updateView(id);
    }

    @Transactional
    @Override
    public void editPost(Long id, PostDto postDto) {
        log.info("edit post {}.", postRepository.findById(id).get().getTitle());
        Post existPost = postRepository.findByGoalIdAndCreated(id, postDto.getCreated()).get();
        LocalDate now = LocalDate.now();

        try {
            if(existPost.getId().equals(id) && postDto.getCreated().isEqual(now)) {
                existPost.setTitle(postDto.getTitle());
                existPost.setContent(postDto.getContent());
                existPost.setPostImg(postDto.getPostImg());
                postRepository.save(existPost);
            }
        } catch (Exception e) {
            log.error("edit post error : {}", e.getMessage());
        }

//        if(postRepository.findById(id).isPresent() // post가 존재하는지 확인
//        && postRepository.findById(id).get().getUserId() == postDto.getUserId()){ // post 작성자 확인
//            Post post = Post.builder()
//                    .id(postDto.getId())
////                    .category(saveCategory(postDto.getCategoryId()))
//                    .title(postDto.getTitle())
//                    .content(postDto.getContent())
//                    .postImg(postDto.getPostImg())
//                    .build();
//            postRepository.save(post);
//        }else {
//            log.error("edit post error.");
//        }
    }

    @Transactional
    @Override
    public void delPost(Long id) {
        if (postRepository.findById(id).isPresent()){
            log.info("delete Post by id");
            postRepository.deleteById(id);
        }else {
            log.error("delete Post error.");
        }
    }

    @Override
    public List<Post> findAllByUserId(Long userId) {
        return postRepository.findByUserIdOrderByIdDesc(userId);
    }

    @Override
    public List<Post> findAllByGoalId(Long goalId) {
        return postRepository.findByGoalIdOrderByIdDesc(goalId);
    }

    @Override
    public Optional<Post> findByGoalIdAndCreated(Long goalId, LocalDate created) {
        return Optional.ofNullable(postRepository.findByGoalIdAndCreated(goalId, created).get());
    }

    @Override
    public void deleteAll(Long goalId, Long userId) { // 작성한 목표 인증글 전체 삭제
        postRepository.deleteAll(
                postRepository.findAllByGoalIdAndUserId(goalId, userId)
        );
    }
}
