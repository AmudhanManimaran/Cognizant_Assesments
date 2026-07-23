# Git Hands-on 3: Branching and Fast-Forward Merging

This exercise demonstrates branch creation, adding files to a new branch, and safely merging those changes back into the master branch.

**GitLab repository:** https://gitlab.com/amudhanmanimaran.am/gitdemo/-/tree/master?ref_type=heads

## Objectives Completed
- Created and switched to a new branch named `GitNewBranch`.
- Added a new file `feature.txt` and committed it to the new branch.
- Merged `GitNewBranch` into `master` using a fast-forward merge.
- Verified Git's protective deletion behavior (`-d`) before pushing the merged history.

## Commands Executed

```bash
git branch GitNewBranch
git checkout GitNewBranch
echo "This is a new feature added in GitNewBranch" > feature.txt
git add feature.txt
git commit -m "Added branch_file.txt to GitNewBranch"

git checkout master
git merge GitNewBranch
git branch -d GitNewBranch
git log --oneline --graph --decorate
git push origin master
```

## Result

The `git log --graph` output confirmed a successful fast-forward merge with a linear history. Git's safety mechanism successfully prevented the deletion of `GitNewBranch` prior to the merge. The `feature.txt` artifact is included in this folder.
