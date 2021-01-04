package ua.lviv.wdelivery.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.lviv.wdelivery.entity.NewRequest;
import ua.lviv.wdelivery.repository.NewRequestRepository;

import java.util.List;

@RestController
@RequestMapping(path = "/admin/submission")
public class AdminRequestsController {

    @Autowired
    NewRequestRepository newRequestRepository;

    @GetMapping(value = "/all", consumes = "application/json", produces = "application/json")
    public List<NewRequest> getAll() {
        return (List<NewRequest>) newRequestRepository.findAll();
    }

    @GetMapping(value = "/{id}", consumes = "application/json", produces = "application/json")
    public NewRequest getById(@PathVariable Long id) {
        return newRequestRepository.findById(id).get();
    }

    @DeleteMapping(value = "/{id}", consumes = "application/json", produces = "application/json")
    public void deleteById(@PathVariable Long id) {
        newRequestRepository.deleteById(id);
    }

/*    @PutMapping(value = "/{id}", consumes = "application/json", produces = "application/json")
    public NewRequest update(@PathVariable Long id, @RequestParam String name, String userName, String userPhone, String userEmail  ) {
        NewRequest request = newRequestRepository.findById(id).get();
        request.setTeamName(name);
        request.setCaptainName(userName);
        request.setCaptainPhone(userPhone);
        request.setCaptainEmail(userEmail);
        newRequestRepository.save(request);
        return request;
    }*/
}
