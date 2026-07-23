#### Git Hands-On 4 (Resolving Merge Conflicts)
**Artifact to include in folder:** `hello.xml`

```markdown
# Git Hands-on 4: Resolving Merge Conflicts

This exercise intentionally created a merge conflict by modifying the same file on two different branches, followed by manual resolution and cleanup.

**GitLab repository:** https://gitlab.com/amudhanmanimaran.am/gitdemo/-/tree/master?ref_type=heads

## Objectives Completed
- Created `hello.xml` on both `GitWork` and `master` branches with conflicting data.
- Triggered a merge conflict by attempting to merge `GitWork` into `master`.
- Manually resolved the conflict markers in the file and committed the correct final code.
- Configured the `.gitignore` to track and ignore the merge tool backup files.

## Commands Executed

```bash
# Setting up the conflict
git checkout -b GitWork
echo "<message>Hello from GitWork branch!</message>" > hello.xml
git add hello.xml
git commit -m "Added hello.xml in GitWork branch"

git checkout master
echo "<message>Hello from the Master branch!</message>" > hello.xml
git add hello.xml
git commit -m "Added hello.xml in master branch"

# Triggering and resolving
git merge GitWork
# Manual resolution in text editor to remove <<<<<<< HEAD markers
git add hello.xml
git commit -m "Resolved merge conflict in hello.xml"

# Cleanup
echo "*_BACKUP_*.xml" >> .gitignore
echo "*_BASE_*.xml" >> .gitignore
echo "*_LOCAL_*.xml" >> .gitignore
echo "*_REMOTE_*.xml" >> .gitignore
git add .gitignore
git commit -m "Fixed case sensitive in .gitignore for merge backups"
git branch -d GitWork
git push origin master