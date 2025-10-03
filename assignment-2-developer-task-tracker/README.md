# TaskHub – Developer Task Tracker

TaskHub is a Spring Boot application for managing projects, developers, and their tasks.  
It is built for a startup-style environment where you need to keep track of projects, team members, deadlines, and overdue work.

---

## Features
- Create and manage Projects
- Add Developers and assign them to projects
- Assign Tasks to developers
- Update task status and priority
- Get all tasks for a developer
- List all developers in a project
- Check overdue tasks
- Restrict developers from having more than 5 tasks in progress
- Prevent updates to tasks marked as DONE
- Find the top 3 developers with the most overdue tasks

---

## API Overview

All APIs are prefixed with `/api`.

### Projects
- Create Project  
  - `POST /api/projects`  
  - Example body:
    ```json
    {
      "name": "Project Alpha",
      "description": "First project for testing"
    }
    ```
- Get All Projects  
  - `GET /api/projects`
- Get Project by ID  
  - `GET /api/projects/1`

---

### Developers
- Create Developer inside a project  
  - `POST /api/developers/{projectId}`  
  - Example body:
    ```json
    {
      "name": "Alice Johnson",
      "email": "alice@example.com"
    }
    ```
- Assign existing developer to another project  
  - `PUT /api/developers/{developerId}/assign/{projectId}`
- Get Developer by ID  
  - `GET /api/developers/1`
- List all Developers in a Project  
  - `GET /api/developers/project/1`

---

### Tasks
- Create Task for a Developer  
  - `POST /api/tasks/developer/{developerId}`  
  - Example body:
    ```json
    {
      "title": "Implement Login API",
      "description": "Create authentication endpoints",
      "status": "TODO",
      "priority": "HIGH",
      "dueDate": "2025-10-05"
    }
    ```
- Get all Tasks of a Developer  
  - `GET /api/tasks/developer/1`
- Update Task Status  
  - `PUT /api/tasks/{taskId}/status?status=IN_PROGRESS`
- Get Overdue Tasks  
  - `GET /api/tasks/overdue`
- Top 3 Developers with Most Overdue Tasks  
  - `GET /api/tasks/top-overdue`

---

## Business Rules
- A developer cannot have more than 5 tasks in `IN_PROGRESS`
- Once a task is marked as `DONE`, it cannot be updated
- Overdue = task due date is before today and status is not `DONE`

---

## Database
- Using MySQL
- Example database name: `taskhub_db`

---

## Quick Test Flow
1. Create a project  
2. Add a developer to it  
3. Assign tasks to the developer  
4. Update task status and check overdue tasks  
5. Try adding more than 5 `IN_PROGRESS` tasks (should fail)  
6. Mark a task as `DONE` and try updating it (should fail)  
7. Check `/tasks/top-overdue` to see the top 3 developers with late tasks  

