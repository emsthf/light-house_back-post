package com.jo.post.postImg;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class PostImgService {

    private S3Service s3Service;
    private final PostImgRepository postImgRepository;

    public void savePost(PostImgDto postImgDto) {
        postImgRepository.save(postImgDto.toEntity());
    }

    public List<PostImgDto> getPostImgList() {
        List<PostImg> postImgList = postImgRepository.findAll();
        List<PostImgDto> postImgDtoList = new ArrayList<>();

        for (PostImg postImg : postImgList) {
            postImgDtoList.add(convertEntityToDto(postImg));
        }

        return postImgDtoList;
    }

    private PostImgDto convertEntityToDto(PostImg postImg) {
        return PostImgDto.builder()
                .id(postImg.getId())
                .url(postImg.getUrl())
                .imgFullPath("https://" + s3Service.CLOUD_FRONT_DOMAIN_NAME + "/" + postImg.getUrl()) //url 주소 변형 cloud front 주소로 변경할것
                .postId(postImg.getPostId())
                .build();
    }
}
