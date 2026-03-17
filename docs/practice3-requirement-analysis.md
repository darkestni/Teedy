# Practice 3 - Requirement Analysis of Teedy

## Scope

This document prepares the deliverables requested in Practice 3:

- 2 end-user feature proposals
- user stories in the "As a... I want... so that..." format
- actionable task breakdown for at least 2 user stories
- board-ready content that can be copied into GitHub Projects

## Assumptions

- A live partner interview was not available while preparing this draft, so the end-user feedback below is synthesized from realistic Teedy usage pain points.
- A personal fork is now available at `darkestni/Teedy`, and the related milestone plus issue cards have been created there.
- Depending on the GitHub account permissions available during setup, the final GitHub Projects board layout may still need to be arranged manually in the web UI.

## End-User Feature Proposals

### Feature 1: Saved Search Alerts

End-user problem:
Users repeatedly rerun the same search queries to check whether any new documents match an important topic, customer, or compliance keyword.

Proposed feature:
Allow users to save a search and receive an in-app notification whenever newly indexed documents match that saved search.

Expected value:
Users can proactively monitor important document categories without manually repeating the same search every day.

### Feature 2: Metadata Templates for Batch Uploads

End-user problem:
When uploading many related documents, users must manually fill the same metadata fields again and again, which is slow and often inconsistent.

Proposed feature:
Allow users to create reusable metadata templates and apply them to multiple selected documents in one action.

Expected value:
Large document batches can be classified faster and with more consistent metadata quality.

## Interview Summary

### Simulated partner feedback

- "I often search for the same terms every morning just to see whether anything new arrived."
- "Batch uploads take too long because I keep re-entering the same metadata."
- "When metadata is entered manually for each file, different teammates use slightly different values."

## User Stories

### User Story 1: Saved Search Alerts

As a compliance coordinator, I want to save a search and receive notifications when new documents match it, so that I can monitor important document categories without rerunning the same search every day.

Acceptance ideas:

- A user can save a search query with filters.
- A user can edit or delete a saved search.
- When a newly indexed document matches a saved search, the owner receives an in-app notification.
- The notification links directly to the matching document.

### User Story 2: Metadata Templates for Batch Uploads

As an archive assistant, I want reusable metadata templates that I can apply to a batch of documents, so that I can upload large document sets quickly and consistently.

Acceptance ideas:

- A user can create, edit, and delete metadata templates.
- A template can store values for common metadata fields.
- A user can select multiple documents and apply one template to all of them.
- The system validates fields before the bulk update is committed.

## Actionable Task Breakdown

The tasks below follow the requested guidelines:

- each task is small enough to fit in half a day to one day
- each task is owned by a single role
- each task is testable
- the breakdown includes functional and non-functional work

### Tasks for User Story 1 - Saved Search Alerts

| ID | Board title | Owner | Estimate | Type | Testable outcome |
| --- | --- | --- | --- | --- | --- |
| 1.1 | [Product] Confirm saved-search fields and alert rules. | Product Owner | 0.5 day | Functional analysis | Story acceptance criteria and field list are approved. |
| 1.2 | [Backend] Add saved-search CRUD API. | Backend Developer | 1 day | Functional | API tests confirm CRUD works for the logged-in user only. |
| 1.3 | [Backend] Implement matching and notification creation. | Backend Developer | 1 day | Functional | A matching document creates exactly one notification for the saved-search owner. |
| 1.4 | [Frontend] Build saved-search management UI. | Frontend Developer | 1 day | Functional | A user can manage saved searches from the browser without API calls by hand. |
| 1.5 | [Frontend] Add notification list and document deep link. | Frontend Developer | 0.5 day | Functional | Clicking the notification opens the matching document view. |
| 1.6 | [QA] Write integration and smoke tests. | QA Engineer | 0.5 day | Testing | Tests fail when the flow is broken and pass when the feature works. |
| 1.7 | [Docs] Update saved-search documentation. | Technical Writer | 0.5 day | Documentation | A new user can follow the docs to create and use a saved search alert. |
| 1.8 | [Review] Review privacy and duplicate-notification behavior. | Reviewer | 0.5 day | Review | Review checklist is signed off and any blocking issue is resolved. |

### Tasks for User Story 2 - Metadata Templates for Batch Uploads

| ID | Board title | Owner | Estimate | Type | Testable outcome |
| --- | --- | --- | --- | --- | --- |
| 2.1 | [Product] Confirm template field scope and validation rules. | Product Owner | 0.5 day | Functional analysis | Approved field matrix and validation rules exist for the story. |
| 2.2 | [Backend] Add metadata template CRUD API. | Backend Developer | 1 day | Functional | API tests verify templates can be created, edited, listed, and deleted. |
| 2.3 | [Backend] Implement bulk apply service logic. | Backend Developer | 1 day | Functional | Selected documents receive the template values in one successful operation. |
| 2.4 | [Frontend] Build metadata template management page. | Frontend Developer | 1 day | Functional | A user can manage templates through the browser. |
| 2.5 | [Frontend] Add bulk apply action in document list. | Frontend Developer | 1 day | Functional | A user can select multiple documents and apply a template from the UI. |
| 2.6 | [Frontend] Add validation feedback for bulk updates. | Frontend Developer | 0.5 day | Non-functional robustness | Invalid fields show clear feedback and no silent data corruption occurs. |
| 2.7 | [QA] Write API and UI tests for templates. | QA Engineer | 0.5 day | Testing | Automated tests cover success and validation-error paths. |
| 2.8 | [Docs] Document batch upload workflow. | Technical Writer | 0.5 day | Documentation | Documentation includes one reproducible example using a template. |

## Suggested GitHub Projects Board Structure

### Column 1: User Stories

- User Story 1: Saved Search Alerts
- User Story 2: Metadata Templates for Batch Uploads

### Column 2: Actionable Tasks

- 1.1 to 1.8
- 2.1 to 2.8

## Recommended Board Card Text

### User story cards

- `User Story 1: Saved Search Alerts`
- `User Story 2: Metadata Templates for Batch Uploads`

### Notes for evaluation

- Show that stories are written in the lecture format.
- Show that tasks are small, role-owned, and testable.
- If the board tool allows labels, add labels such as `story`, `task`, `frontend`, `backend`, `qa`, and `docs` to improve readability.
