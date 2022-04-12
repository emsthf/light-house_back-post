package com.jo.post.postImg;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@ToString
@NoArgsConstructor
public class PostImgDto {

    private Long id;
    private String url;
    private String imgFullPath;
    private Long postId;

    public PostImg toEntity(){
        PostImg build = PostImg.builder()
                .id(id)
                .url(url)
                .postId(postId)
                .build();
        return build;
    }

    @Builder
    public PostImgDto(Long id, String url, String imgFullPath, Long postId) {
        this.id = id;
        this.url = url;
        this.imgFullPath = imgFullPath;
        this.postId = postId;
    }
}
