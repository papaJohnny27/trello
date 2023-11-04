package kz.bitlab.bigprojecttrello.controller;

import kz.bitlab.bigprojecttrello.dto.FoldersDto;
import kz.bitlab.bigprojecttrello.dto.TaskCategoriesDto;
import kz.bitlab.bigprojecttrello.dto.TasksDto;
import kz.bitlab.bigprojecttrello.model.Folders;
import kz.bitlab.bigprojecttrello.service.FoldersService;
import kz.bitlab.bigprojecttrello.service.TaskCategoryService;
import kz.bitlab.bigprojecttrello.service.TasksService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class FolderController {

    private final FoldersService foldersService;
    private final TasksService tasksService;
    private final TaskCategoryService categoryService;

    @GetMapping("/")
    public String getFolders(Model model){
        List<FoldersDto> folders = foldersService.getAll();
        model.addAttribute("folders",folders);

        return "index";
    }
    @GetMapping("/folders/{folderId}")
    public String getDetail(@PathVariable Long folderId,Model model){
        FoldersDto folder = foldersService.getById(folderId);
        List<TasksDto> tasks = tasksService.getAllByFolderId(folderId);
        List<TaskCategoriesDto> categories = categoryService.getAll();
        model.addAttribute("folder",folder);
        model.addAttribute("tasks",tasks);
        model.addAttribute("categories",categories);
        return "task-detail";
    }

    @PostMapping("/folders")
    public String create(@RequestParam String name){
        FoldersDto foldersDto = new FoldersDto();
        foldersDto.setName(name);
        foldersService.create(foldersDto);

        return "redirect:/";
    }
    @DeleteMapping("/folders/{folderId}")
        public String deleteCategory(@PathVariable("folderId") Long folderId,@RequestParam("categoryId") Long categoryId){
        foldersService.deleteCategory(folderId,categoryId);

        return "redirect:/folders/" + folderId;
    }
}
