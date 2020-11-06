package App.BusinessLayer.Pojo;

public class FavoriteDirectionPOJO {

    private int idFavoriteDirection;

    private double lat;

    private double lng;

    private String nameDirection;

    private String nameAddress;

    private int FavoriteDirectionOwner;

    public double getLat() {
        return lat;
    }

    public int getIdFavoriteDirection() {
        return idFavoriteDirection;
    }

    public void setIdFavoriteDirection(int idFavoriteDirection) {
        this.idFavoriteDirection = idFavoriteDirection;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public String getNameDirection() {
        return nameDirection;
    }

    public void setNameDirection(String nameDirection) {
        this.nameDirection = nameDirection;
    }

    public String getNameAddress() {
        return nameAddress;
    }

    public void setNameAddress(String nameAddress) {
        this.nameAddress = nameAddress;
    }

    public int getFavoriteDirectionOwner() {
        return FavoriteDirectionOwner;
    }

    public void setFavoriteDirectionOwner(int favoriteDirectionOwner) {
        FavoriteDirectionOwner = favoriteDirectionOwner;
    }
}
