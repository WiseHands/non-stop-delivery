package ua.lviv.wdelivery.routing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import ua.lviv.wdelivery.entity.*;
import ua.lviv.wdelivery.repository.*;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Controller
public class HttpRequestsController {

    @Autowired
    NewRequestRepository newRequestRepository;

    @GetMapping({"/"})
    public String main(Model model, @RequestParam(value = "name", required = false) String name) {
        model.addAttribute("name", name);

        return "main";
    }
    @GetMapping(value = "/admin/submission/edit/{requestId}")
    public String submissionRequestEdit(Model model, @PathVariable("requestId") Long requestId) {
        NewRequest request = newRequestRepository.findById(requestId).get();
        model.addAttribute("request", request);

        return "RequestEntryEdit";
    }
    @GetMapping(value = "/request/{requestId}")
    public String requestView(Model model, @PathVariable("requestId") Long requestId) {
        NewRequest request = newRequestRepository.findById(requestId).get();
        model.addAttribute("request", request);

        return "RequestView";
    }

    @GetMapping(value = "/admin")
    public String admin(Model model) {
        List<NewRequest> requestsList = (List<NewRequest>) newRequestRepository.findAll();
        model.addAttribute("requestsList", requestsList);
        return "AdminRequestsList";
    }

    @GetMapping(value = "/admin/newForm")
    public String newForm(Model model, @RequestParam(value = "name", required = false) String name) {
        model.addAttribute("name", name);

        return "newForm";
    }

}
