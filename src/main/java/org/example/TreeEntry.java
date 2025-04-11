package org.example;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class TreeEntry {
    @Id @GeneratedValue
    private Long id;
    private String inputNumbers;
    private String treeStructure;
    private boolean balanced;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getInputNumbers() { return inputNumbers; }
    public void setInputNumbers(String inputNumbers) { this.inputNumbers = inputNumbers; }
    public String getTreeStructure() { return treeStructure; }
    public void setTreeStructure(String treeStructure) { this.treeStructure = treeStructure; }
    public boolean isBalanced() { return balanced; }
    public void setBalanced(boolean balanced) { this.balanced = balanced; }
}