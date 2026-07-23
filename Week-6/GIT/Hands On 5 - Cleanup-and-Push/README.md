# Git Hands-on 5: Remote Synchronization and Cleanup

This final exercise focuses on verifying the integrity of the repository, cleaning up untracked temporary files, and ensuring perfect synchronization between the local environment and the remote GitLab server.

**GitLab repository:** https://gitlab.com/amudhanmanimaran.am/gitdemo/-/tree/master?ref_type=heads

## Objectives Completed
- Removed lingering untracked merge backup files from the local directory.
- Verified a perfectly clean working tree state.
- Listed all local and remote branches.
- Executed pull and push commands to ensure total alignment with GitLab.

## Commands Executed

```bash
rm hello_BACKUP_*.xml
git status
git branch -a
git pull origin master
git push origin master
```

## Result

The repository was fully cleaned of all temporary `.xml` backup files generated during the merge conflict exercise. The `git status` command returned `nothing to commit, working tree clean`, and the final push confirmed that everything was completely up to date with the remote repository.
