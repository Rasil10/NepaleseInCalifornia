package sunbidemo.nepaleseincalifornia;

/**
 * Created by Rasil10 on 2017-11-13.
 */

public class DrawerItem {
    String ItemName;
    int imgResID;

    public DrawerItem(String itemName, int imgResID) {
        ItemName = itemName;
        this.imgResID = imgResID;
    }

    public DrawerItem() {

    }

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String itemName) {
        ItemName = itemName;
    }

    public int getImgResID() {
        return imgResID;
    }

    public void setImgResID(int imgResID) {
        this.imgResID = imgResID;
    }
}

