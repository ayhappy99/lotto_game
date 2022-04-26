package com.example.lotto_game;

public class MemoryCard {
    private int imageId;
    private boolean isFaceUp;


    public MemoryCard(int imageId, boolean isFaceUp) {
        this.imageId = imageId;
        this.isFaceUp = isFaceUp;

    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public boolean isFaceUp() {
        return isFaceUp;
    }

    public void setFaceUp(boolean faceUp) {
        isFaceUp = faceUp;
    }

}
