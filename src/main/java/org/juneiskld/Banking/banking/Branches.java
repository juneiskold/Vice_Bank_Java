package org.juneiskld.Banking.banking;

import java.util.ArrayList;
import java.util.List;

public class Branches {

    private List<Branch> branches;

    public Branches() {
        this.branches = new ArrayList<>();
    }

    public void addBranch(Branch branch) {
        this.branches.add(branch);
    }

    public List<Branch> getBranches() {
        return branches;
    }
}
