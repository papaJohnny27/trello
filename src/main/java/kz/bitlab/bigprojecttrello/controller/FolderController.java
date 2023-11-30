package kz.bitlab.bigprojecttrello.controller;

import kz.bitlab.bigprojecttrello.dto.FolderDto;
import kz.bitlab.bigprojecttrello.dto.TaskCategoryDto;
import kz.bitlab.bigprojecttrello.dto.TaskDto;
import kz.bitlab.bigprojecttrello.service.FolderService;
import kz.bitlab.bigprojecttrello.service.TaskCategoryService;
import kz.bitlab.bigprojecttrello.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class FolderController {

    private final FolderService folderService;
    private final TaskService taskService;
    private final TaskCategoryService categoryService;

    @GetMapping("/")
    public String getFolders(Model model) {
        List<FolderDto> folders = folderService.getAll();
        model.addAttribute("folders", folders);

        return "index";
    }

    @GetMapping("/folders/{folderId}")
    public String getDetail(@PathVariable Long folderId, Model model) {
        FolderDto folder = folderService.getById(folderId);
        List<TaskDto> tasks = taskService.getAllByFolderId(folderId);
        List<TaskCategoryDto> categories = categoryService.getAll();
        model.addAttribute("folder", folder);
        model.addAttribute("tasks", tasks);
        model.addAttribute("categories", categories);
        return "task-detail";
    }

    @PostMapping("/folders")
    public String create(@RequestParam String name) {
        FolderDto folderDto = new FolderDto();
        folderDto.setName(name);
        folderService.create(folderDto);

        return "redirect:/";
    }

    @DeleteMapping("/folders/{folderId}")
    public String deleteCategory(@PathVariable("folderId") Long folderId, @RequestParam("categoryId") Long categoryId) {
        folderService.deleteCategory(folderId, categoryId);

        return "redirect:/folders/" + folderId;
    }
}
