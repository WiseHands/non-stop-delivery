package ua.lviv.wdelivery.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ua.lviv.wdelivery.entity.NewRequest;
import ua.lviv.wdelivery.repository.NewRequestRepository;

@RestController
@RequestMapping(path = "/submission")
public class CourierRequestManagementController {

    @Autowired
    NewRequestRepository newRequestRepository;

    @PutMapping(value = "/{requestId}/{orderInCourierProcessing}", consumes = "application/json", produces = "application/json")
    public void markAccepted(@PathVariable Long requestId, @PathVariable boolean orderInCourierProcessing, @RequestBody String courierName) throws Exception {
        NewRequest request = newRequestRepository.findById(requestId).get();
        if (request.isOrderInCourierProcessing()) {
            throw new Exception("Already assigned");
            //throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        request.setOrderInCourierProcessing(orderInCourierProcessing);
        request.setCourierName(courierName);
        newRequestRepository.save(request);
    }

}