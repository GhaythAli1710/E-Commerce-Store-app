package ghaythali1710.e_commerce_store_app;

public class ClassObj {

    private String nameClass;
    private int imageId;

    public ClassObj(){}

    public ClassObj(String nameClass, int imageId) {
        this.nameClass = nameClass;
        this.imageId = imageId;
    }

    public String getNameClass() {
        return nameClass;
    }

    public void setNameClass(String nameClass) {
        this.nameClass = nameClass;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
