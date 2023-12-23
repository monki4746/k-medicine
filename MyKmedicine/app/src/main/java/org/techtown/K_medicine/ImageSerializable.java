package org.techtown.K_medicine;

import java.io.Serializable;

public class ImageSerializable implements Serializable {
    String imageUrl;

    ImageSerializable(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
