# Git Hands-On 1: Git Configuration & Basic Workflow

This exercise was completed using **GitLab** as specified in the lab manual. The repository named `GitDemo` was created under my GitLab account.

**GitLab repository:** https://gitlab.com/amudhanmanimaran.am/gitdemo/-/tree/master?ref_type=heads

## Objectives Completed
- Configured Git with a global username and email.
- Set Notepad++ as the default Git commit-message editor.
- Initialized a local repository and created a tracked file.
- Pushed a local commit to a remote GitLab repository.

## Commands Executed

```bash
git version
git config --global user.name "AmudhanManimaran"
git config --global user.email "amudhanmanimaran.am@gmail.com"
git config --global --list

git config --global core.editor "notepad++.exe -multiInst -nosession"
git config --global -e

git init GitDemo
cd GitDemo
echo "Welcome to the version control" >> welcome.txt
git add welcome.txt
git commit -m "Initial commit Added the welcome.txt file to the repository"
git push origin master