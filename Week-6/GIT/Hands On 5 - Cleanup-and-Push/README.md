#### Git Hands-On 5 (Cleanup and Remote Push)
**Artifact to include in folder:** None required (The `README.md` acts as the final proof).

```markdown
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