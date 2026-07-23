# Git Hands-on 2: Excluding Files with .gitignore

This exercise demonstrates how to prevent Git from tracking specific files and folders using a `.gitignore` file.

**GitLab repository:** https://gitlab.com/amudhanmanimaran.am/gitdemo

## Objectives Completed
- Created a `.log` file and a `log` directory.
- Configured a `.gitignore` file to ignore all `.log` files and the entire `log` folder.
- Verified the working tree status to ensure the rules were applied correctly.

## Commands Executed

```bash
mkdir log
echo "Sample log entry" >> log/app.log
echo "Error log entry" >> error.log
git status

echo "*.log" > .gitignore
echo "log/" >> .gitignore

git status
git add .gitignore
git commit -m "Added .gitignore to exclude .log files and log folder"
git push origin master
```

## Result

Before the `.gitignore` was applied, Git tracked the `.log` files. After the `.gitignore` was applied, `git status` confirmed a clean working tree, proving the files were successfully ignored. The `.gitignore` artifact is included in this folder.
