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

### US1 - Saved Search Alerts

As a compliance coordinator, I want to save a search and receive notifications when new documents match it, so that I can monitor important document categories without rerunning the same search every day.

Acceptance ideas:

- A user can save a search query with filters.
- A user can edit or delete a saved search.
- When a newly indexed document matches a saved search, the owner receives an in-app notification.
- The notification links directly to the matching document.

### US2 - Metadata Templates for Batch Uploads

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

### Tasks for US1 - Saved Search Alerts

| ID | Task | Owner | Estimate | Type | Testable outcome |
| --- | --- | --- | --- | --- | --- |
| US1-T1 | Confirm saved-search fields, alert trigger rules, and notification wording. | Product Owner | 0.5 day | Functional analysis | Story acceptance criteria and field list are approved. |
| US1-T2 | Add persistence model and REST endpoints for create, update, list, and delete saved searches. | Backend Developer | 1 day | Functional | API tests confirm CRUD works for the logged-in user only. |
| US1-T3 | Implement matching logic that checks new documents against saved searches and creates notification records. | Backend Developer | 1 day | Functional | A matching document creates exactly one notification for the saved-search owner. |
| US1-T4 | Add UI for "Save this search" plus a management screen for existing saved searches. | Frontend Developer | 1 day | Functional | A user can manage saved searches from the browser without API calls by hand. |
| US1-T5 | Add notification list entry and deep link to the matched document. | Frontend Developer | 0.5 day | Functional | Clicking the notification opens the matching document view. |
| US1-T6 | Write API integration tests and one end-to-end smoke test for the full alert flow. | QA Engineer | 0.5 day | Testing | Tests fail when the flow is broken and pass when the feature works. |
| US1-T7 | Update user documentation and release notes for saved searches and notifications. | Technical Writer | 0.5 day | Documentation | A new user can follow the docs to create and use a saved search alert. |
| US1-T8 | Review privacy, duplicate-notification behavior, and UI copy before closing the story. | Reviewer | 0.5 day | Review | Review checklist is signed off and any blocking issue is resolved. |

### Tasks for US2 - Metadata Templates for Batch Uploads

| ID | Task | Owner | Estimate | Type | Testable outcome |
| --- | --- | --- | --- | --- | --- |
| US2-T1 | Confirm which metadata fields can be templated and which validation rules apply in bulk updates. | Product Owner | 0.5 day | Functional analysis | Approved field matrix and validation rules exist for the story. |
| US2-T2 | Add persistence model and REST endpoints for metadata template CRUD. | Backend Developer | 1 day | Functional | API tests verify templates can be created, edited, listed, and deleted. |
| US2-T3 | Implement bulk-apply service logic to update selected documents from a chosen template. | Backend Developer | 1 day | Functional | Selected documents receive the template values in one successful operation. |
| US2-T4 | Build a template management page in the web UI. | Frontend Developer | 1 day | Functional | A user can manage templates through the browser. |
| US2-T5 | Add bulk-selection and "Apply metadata template" action to the document list UI. | Frontend Developer | 1 day | Functional | A user can select multiple documents and apply a template from the UI. |
| US2-T6 | Add validation feedback and partial-failure handling for invalid bulk updates. | Frontend Developer | 0.5 day | Non-functional robustness | Invalid fields show clear feedback and no silent data corruption occurs. |
| US2-T7 | Write API and UI tests for template CRUD and bulk apply behavior. | QA Engineer | 0.5 day | Testing | Automated tests cover success and validation-error paths. |
| US2-T8 | Update help documentation with a quick-start example for batch uploads. | Technical Writer | 0.5 day | Documentation | Documentation includes one reproducible example using a template. |

## Suggested GitHub Projects Board Structure

### Column 1: User Stories

- US1 - Saved Search Alerts
- US2 - Metadata Templates for Batch Uploads

### Column 2: Actionable Tasks

- US1-T1 to US1-T8
- US2-T1 to US2-T8

## Recommended Board Card Text

### User story cards

- `US1 - As a compliance coordinator, I want to save a search and receive notifications when new documents match it, so that I can monitor important document categories without rerunning the same search every day.`
- `US2 - As an archive assistant, I want reusable metadata templates that I can apply to a batch of documents, so that I can upload large document sets quickly and consistently.`

### Notes for evaluation

- Show that stories are written in the lecture format.
- Show that tasks are small, role-owned, and testable.
- If the board tool allows labels, add labels such as `story`, `task`, `frontend`, `backend`, `qa`, and `docs` to improve readability.
