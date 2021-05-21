package test.exam.web;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import test.exam.models.binding.ItemAddBindingModem;
import test.exam.models.service.ItemServiceModel;
import test.exam.service.ItemService;
import test.exam.service.UserService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/items")
public class ItemsController {

    private final ItemService itemService;
    private final ModelMapper modelMapper;
    private final UserService userService;

    @Autowired
    public ItemsController(ItemService itemService,
                           ModelMapper modelMapper,
                           UserService userService) {
        this.itemService = itemService;
        this.modelMapper = modelMapper;
        this.userService = userService;
    }

    @GetMapping("/add")
    public String add(Model model){
        if(!model.containsAttribute("itemAddBindingModem")){
            model.addAttribute("itemAddBindingModem", new ItemAddBindingModem());
        }
        return "add-item";
    }

    @PostMapping("/add")
    public String addConfirm(@Valid@ModelAttribute("itemAddBindingModem")
                             ItemAddBindingModem itemAddBindingModem,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes
                             ){
        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("itemAddBindingModem", itemAddBindingModem);
            redirectAttributes
                    .addFlashAttribute("org.springframework.validation.BindingResult.itemAddBindingModem",
                            bindingResult);
            return "redirect:add";
        }

        this.itemService.addItem(this.modelMapper.map(itemAddBindingModem, ItemServiceModel.class));

        return "redirect:/";
    }

    @GetMapping("/details")
    public ModelAndView details(@RequestParam("id")String id,
                                ModelAndView modelAndView){
        modelAndView.addObject("item", this.itemService.findById(id));
        modelAndView.setViewName("details-item");
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id")String id){

        this.itemService.deleteById(id);
        return "redirect:/";
    }

}
