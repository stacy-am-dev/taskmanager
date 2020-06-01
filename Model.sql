create database TaskManager
use TaskManager

go
Create Table Employee
(
	employee_id uniqueidentifier default newid() Primary key,
	username varchar(30) unique ,
	password varchar (30) ,
	first_name varchar (30) not null,
	last_name varchar  (30) not null,
	email varchar (30) unique
)	

go
Create Table Skill
(
	skill_id uniqueidentifier default newid() Primary key,
	skill_name varchar(50) unique not null,
	min_level numeric (1,0) not null,
	max_level numeric (1,0) not null,
	description varchar(250)
)	

go
Create Table EmployeeSkill
(
	employee_id uniqueidentifier Foreign Key References Employee(employee_id),
	skill_id uniqueidentifier Foreign Key References Skill(skill_id),
	skill_level numeric(1,0) not null,
	Constraint EmployeeSkill Primary Key(employee_id, skill_id, skill_level)
)


go
Create Table ProcessStatus
(
	process_status varchar(20) Primary key 
)
insert ProcessStatus(process_status) values
('planning'),
('planned'), 
('in_progress'), 
('error'), 
('cancelled'), 
('completed')


go
Create Table ProcessTemplate
(
	process_template_id uniqueidentifier default newid() Primary key,
	name varchar(100) not null,
	description varchar(250),
	parameters varchar(4000)
)	

go
Create Table ProcessTemplateRule
(
	process_template_rule_id uniqueidentifier default newid() Primary key,
	process_template_id uniqueidentifier Foreign Key References ProcessTemplate(process_template_id),
	name varchar(100) not null,
	description varchar(250),
	rule_class varchar(100),
	_order integer not null
)

go
Create Table Process
(
	process_id uniqueidentifier default newid() Primary Key,
	process_template_id uniqueidentifier Foreign key References ProcessTemplate(process_template_id),
	process_status varchar(20) Not null default 'PLANNED' check (process_status IN(Select process_status from ProcessStatus)),
	name varchar(100) not null,
	description varchar(250),
	expectation_start_date Datetime ,
	expectation_end_date Datetime, check(expectation_start_date <= expectation_end_date),
	start_date datetime,
	end_date datetime, check (start_date<=end_date),
	parameters varchar(4000)
)

go
Create Table TaskStatus
(
	task_status varchar(20) Primary key 
)
insert TaskStatus (task_status) values
('planning'),
('planned'), 
('not_started'), 
('in_progress'), 
('error'), 
('waiting'), 
('cancelled'), 
('completed')

go
Create Table TaskType
(
	task_type varchar(20) Primary key 
)
insert TaskStatus (task_status) values
('JAVA_ACTION'), 
('MANUAL')

go
Create Table TaskPriority
(
	task_priority numeric(1,0) Primary key 
)
insert TaskStatus (task_status) values
(1), 
(2),
(3),
(4),
(5)

go
Create Table TaskTemplate
(
	task_template_id uniqueidentifier default newid() Primary key,
	task_type varchar(20) Not null check (task_type IN(Select task_type from TaskType)),
	task_priority numeric(1,0) not null check (task_priority IN(Select task_priority from TaskPriority)),
	name varchar(100) not null,
	description varchar(250),
	expectation_execution_time datetime,
	skills varchar(4000),
	parameters varchar(4000)
)	

go
Create Table TaskTemplateRule
(
	task_template_rule_id uniqueidentifier default newid() Primary key,
	task_template_id uniqueidentifier Foreign Key References TaskTemplate(task_template_id),
	name varchar(100) not null,
	description varchar(250),
	rule_class varchar(100),
	_order integer not null
)	

go
Create Table Task
(
	task_id uniqueidentifier default newid() Primary Key,
	task_template_id uniqueidentifier Foreign key References TaskTemplate(task_template_id),
	task_status varchar(20) Not null default 'PLANNED' check (task_status IN(Select task_status from TaskStatus)),
	task_type varchar(20) Not null check (task_type IN(Select task_type from TaskType)),
	task_priority numeric(1,0) not null check (task_priority IN(Select task_priority from TaskPriority)),
	name varchar(100) not null,
	description varchar(250),
	process_id uniqueidentifier Foreign key References Process(process_id),
	assignee_id uniqueidentifier Foreign Key References Employee(employee_id),
	expectation_start_date Datetime ,
	expectation_end_date Datetime, check(expectation_start_date <= expectation_end_date),
	start_date datetime,
	end_date datetime, check (start_date<=end_date),
	parameters varchar(4000)
)	

go
Create Table TaskDependency
(
	task_id_from uniqueidentifier Foreign key References Task(task_id),
	task_id_to uniqueidentifier Foreign key References Task(task_id),
	Constraint TaskDependency Primary Key(task_id_from, task_id_to)

)	

go
Create Table TaskSkill
(
	task_id uniqueidentifier Foreign key References Task(task_id),
	skill_id uniqueidentifier Foreign key References Skill(skill_id),
	skill_level numeric(1,0) not null,
	Constraint TaskDependency Primary Key(task_id, skill_id,skill_level)
)	