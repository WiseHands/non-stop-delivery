package ua.lviv.wdelivery.jsonmapper;

public class NewRequestJsonBody {

    private String courierName;
    private String shopName;
    private String orderNumber;
    private String orderPrice;
    private String streetName;
    private String buildingName;
    private String apartmentName;
    private String entranceCode;

    public NewRequestJsonBody(String courierName, String shopName, String orderNumber, String orderPrice, String streetName, String buildingName, String apartmentName, String entranceCode) {
        this.courierName = courierName;
        this.shopName = shopName;
        this.orderNumber = orderNumber;
        this.orderPrice = orderPrice;
        this.streetName = streetName;
        this.buildingName = buildingName;
        this.apartmentName = apartmentName;
        this.entranceCode = entranceCode;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(String orderPrice) {
        this.orderPrice = orderPrice;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public String getApartmentName() {
        return apartmentName;
    }

    public void setApartmentName(String apartmentName) {
        this.apartmentName = apartmentName;
    }

    public String getEntranceCode() {
        return entranceCode;
    }

    public void setEntranceCode(String entranceCode) {
        this.entranceCode = entranceCode;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getCourierName() {
        return courierName;
    }

    public void setCourierName(String courierName) {
        this.courierName = courierName;
    }
}
