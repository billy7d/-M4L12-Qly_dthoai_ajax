package controller;

import model.Smartphone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.SmartphoneService;

@Controller
@RequestMapping(value = "/smartphones")

public class SmartphoneController {

    @Autowired
    private SmartphoneService smartphoneService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView createSmartphonePage() {
        ModelAndView mav = new ModelAndView("phones/all-phones");
        mav.addObject("sPhone", new Smartphone());
        return mav;
    }

    @RequestMapping(value = "", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Smartphone createSmartphone(@RequestBody Smartphone smartphone) {
        return smartphoneService.save(smartphone);
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Iterable<Smartphone> allPhones() {
        return smartphoneService.findAll();
    }

    @GetMapping("")
    public ModelAndView allPhonesPage() {
        ModelAndView modelAndView = new ModelAndView("phones/all-phones");

        modelAndView.addObject("allphones", allPhones());
        return modelAndView;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Smartphone deleteSmartphone(@PathVariable Integer id) {
        return smartphoneService.delete(id);
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editSmartphonePage(@PathVariable Integer id){
        Smartphone smartphone = smartphoneService.findOne(id);
        if(smartphone != null) {
            ModelAndView modelAndView = new ModelAndView("phones/edit-phone");
            modelAndView.addObject("sPhone",smartphone);
            return modelAndView;
        }
        return null;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Smartphone editSmartphone(@PathVariable Integer id, @RequestBody Smartphone smartphone){
        smartphone.setId(id);
        return smartphoneService.save(smartphone);
    }

}
