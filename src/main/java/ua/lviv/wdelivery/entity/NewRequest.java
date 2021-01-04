package ua.lviv.wdelivery.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
public class NewRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank(message = "shopName is mandatory")
    @Column
    private String shopName;

    @NotBlank(message = "courierName is mandatory")
    @Column
    private String courierName;

    @NotBlank(message = "orderNumber is mandatory")
    @Column
    private String orderNumber;

    @NotBlank(message = "orderPrice is mandatory")
    @Column
    private String orderPrice;

    @NotBlank(message = "streetName is mandatory")
    @Column
    private String streetName;

    @NotBlank(message = "buildingName is mandatory")
    @Column
    private String buildingName;

    @NotBlank(message = "apartmentName is mandatory")
    @Column
    private String apartmentName;

    @Column
    private String entranceCode;

    @Column
    private String utcDateTime;

    @Column
    private String userAgent;

    @Column
    private boolean orderInCourierProcessing;

    public Long getId() {
        return id;
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

    public String getUtcDateTime() {
        return utcDateTime;
    }

    public void setUtcDateTime(String utcDateTime) {
        this.utcDateTime = utcDateTime;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public boolean isOrderInCourierProcessing() {
        return orderInCourierProcessing;
    }

    public void setOrderInCourierProcessing(boolean orderInCourierProcessing) {
        this.orderInCourierProcessing = orderInCourierProcessing;
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
