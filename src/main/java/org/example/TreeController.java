package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Controller
public class TreeController {

    @Autowired
    private TreeEntryRepository treeEntryRepository;

    // HTML Endpoints
    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/enter-numbers")
    public String showForm(Model model) {
        return "enter-numbers";
    }

    @PostMapping("/process-numbers")
    public String processNumbers(@RequestParam String numbers, Model model) {
        return processAndSave(numbers, model, false);
    }

    @PostMapping("/balanced-tree")
    public String createBalancedTree(@RequestParam String numbers, Model model) {
        return processAndSave(numbers, model, true);
    }

    @GetMapping("/previous-trees")
    public String showPreviousTrees(Model model) {
        model.addAttribute("trees", treeEntryRepository.findAll());
        return "previous-trees";
    }

    // API Endpoints
    @PostMapping(value = "/api/process-numbers", produces = "application/json")
    @ResponseBody
    public Map<String, Object> processNumbersApi(@RequestParam String numbers) {
        return buildResponse(numbers, false);
    }

    @PostMapping(value = "/api/balanced-tree", produces = "application/json")
    @ResponseBody
    public Map<String, Object> balancedTreeApi(@RequestParam String numbers) {
        return buildResponse(numbers, true);
    }

    @GetMapping(value = "/api/previous-trees", produces = "application/json")
    @ResponseBody
    public List<TreeEntry> getPreviousTreesApi() {
        return treeEntryRepository.findAll();
    }

    // Helper Methods
    private String processAndSave(String numbers, Model model, boolean balanced) {
        try {
            Map<String, Object> response = buildResponse(numbers, balanced);
            model.addAllAttributes(response);

            TreeEntry entry = new TreeEntry();
            entry.setInputNumbers(numbers);
            entry.setTreeStructure(response.get("treeStructure").toString());
            entry.setBalanced(balanced);
            treeEntryRepository.save(entry);

            return "process-numbers";
        } catch (NumberFormatException e) {
            model.addAttribute("error", "Invalid number format");
            return "process-numbers";
        }
    }

    private Map<String, Object> buildResponse(String numbers, boolean balanced) {
        int[] nums = Arrays.stream(numbers.split(","))
                .map(String::trim)
                .mapToInt(Integer::parseInt)
                .toArray();

        BinarySearchTree tree;
        if (balanced) {
            tree = new BinarySearchTree().buildBalancedTree(nums);
        } else {
            tree = new BinarySearchTree();
            for (int num : nums) tree.insert(num);
        }

        return Map.of(
                "inputNumbers", numbers,
                "treeStructure", tree.visualize(),
                "balanced", balanced,
                "formattedTree", tree.visualizeFormatted()
        );
    }
}