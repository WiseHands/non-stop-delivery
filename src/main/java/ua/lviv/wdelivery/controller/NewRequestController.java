
package ua.lviv.wdelivery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ua.lviv.wdelivery.entity.NewRequest;
import ua.lviv.wdelivery.jsonmapper.NewRequestJsonBody;
import ua.lviv.wdelivery.repository.NewRequestRepository;
import ua.lviv.wdelivery.util.Mailer;

import java.time.Clock;

@Controller
@RequestMapping(path = "/admin")
public class NewRequestController {

    @Autowired
    NewRequestRepository newRequestRepository;

    @Value("${mailer.userName}")
    private String gmailUserName;

    @Value("${mailer.password}")
    private String gmailPassword;

    @Value("${wdelivery.admin.email}")
    private String shopAdmin;

    @PostMapping(value = "/newrequest", consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> addRequestViaJson(@RequestBody NewRequestJsonBody newRequestJsonBody, @RequestHeader(value="User-Agent") String userAgent, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            System.out.println("Errors " + bindingResult.hasErrors());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        NewRequest request = new NewRequest();
        request.setCourierName(newRequestJsonBody.getCourierName());
        request.setShopName(newRequestJsonBody.getShopName());
        request.setOrderNumber(newRequestJsonBody.getOrderNumber());
        request.setOrderPrice(newRequestJsonBody.getOrderPrice());
        request.setStreetName(newRequestJsonBody.getStreetName());
        request.setBuildingName(newRequestJsonBody.getBuildingName());
        request.setApartmentName(newRequestJsonBody.getApartmentName());
        request.setEntranceCode(newRequestJsonBody.getEntranceCode());
        request.setUtcDateTime(Clock.systemUTC().instant().toString());
        request.setUserAgent(userAgent);

        newRequestRepository.save(request);

        Long requestId = request.getId();
        String shopName = newRequestJsonBody.getShopName();
        String orderNumber = newRequestJsonBody.getOrderNumber();
        String orderPrice = newRequestJsonBody.getOrderPrice();
        String streetName = newRequestJsonBody.getStreetName();
        String buildingName = newRequestJsonBody.getBuildingName();
        String apartmentName = newRequestJsonBody.getApartmentName();
        String entranceCode = newRequestJsonBody.getEntranceCode();

        String titleMessage = "Заявка для кур'єра";
        String message = String.format("Доброго дня, заклад %s, замовлення № %s на суму %s за адресою %s, %s/%s%s </br>%s",
                shopName, orderNumber, orderPrice, streetName, buildingName, apartmentName, ", код під'їзду " + entranceCode,
                "Лінк для перегляду або підтвердження заявки: http://localhost:8080/request/" + requestId);
        String addressList = "research.010@gmail.com, 00cc0000@gmail.com";

        //for send message check to own Gmail setting https://myaccount.google.com/lesssecureapps pls turn ON for sending message
        Mailer.send(gmailUserName, gmailPassword, addressList, titleMessage, message);

        String adminEmailTitle = String.format("Нова заявка із замовленням №%s", orderNumber);
        String adminMessage = String.format("Відправлено нову заявку кур'єрам, заклад %s, номер замовлення %s, на суму %s, вул. %s, буд. %s, кв. %s %s",
                shopName, orderNumber, orderPrice, streetName, buildingName, apartmentName, ", код під'їзду " + entranceCode);
        Mailer.send(gmailUserName, gmailPassword, shopAdmin, adminEmailTitle, adminMessage);
        return new ResponseEntity<>("Request is created successfully", HttpStatus.CREATED);
    }

}
