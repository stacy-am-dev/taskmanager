create Table Employee
(
	employee_id int(10) Primary key auto_increment,
	username varchar(30) unique,
	password varchar (30),
	first_name varchar (30) not null,
	last_name varchar (30) not null,
	email varchar (30) unique
);

create Table Skill
(
	skill_id int(10) Primary key auto_increment,
	skill_name varchar(50) unique not null,
	min_level numeric (1,0) not null,
	max_level numeric (1,0) not null,
	description varchar(250)
);	

create Table EmployeeSkill
(
	employee_id int(10),
	skill_id int(10),
	skill_level numeric(1,0) not null
);

create Table ProcessTemplate
(
	process_template_id int(10) Primary key auto_increment,
	name varchar(100) not null,
	description varchar(250),
	parameters varchar(4000)
);	

create Table ProcessTemplateRule
(
	process_template_rule_id int(10) Primary key auto_increment,
	process_template_id int(10),
	name varchar(100) not null,
	description varchar(250),
	rule_class varchar(100),
	_order integer not null
);

create Table Process
(
	process_id int(10) Primary key auto_increment,
	process_template_id int(10),
	process_status enum('planning', 'planned','in_progress', 'error', 'cancelled', 
    'completed') Not null default 'planned',
	name varchar(100) not null,
	description varchar(250),
	expectation_start_date Datetime ,
	expectation_end_date Datetime, check(expectation_start_date <= expectation_end_date),
	start_date datetime,
	end_date datetime, check (start_date<=end_date),
	parameters varchar(4000)
);

create Table TaskTemplate
(
	task_template_id int(10) Primary key auto_increment,
	task_type enum('java_action', 'manual') Not null,
	task_priority enum('low','normal','major','critical','blocker') not null,
	name varchar(100) not null,
	description varchar(250),
	expectation_execution_time datetime,
	skills varchar(4000),
	parameters varchar(4000)
);

create Table TaskTemplateRule
(
	task_template_rule_id int(10) Primary key auto_increment,
	task_template_id int(10),
	name varchar(100) not null,
	description varchar(250),
	rule_class varchar(100),
	_order integer not null
);	

create Table Task
(
	task_id int(10) Primary key auto_increment,
	task_template_id int(10),
	task_status enum('planning','planned', 'not_started', 'in_progress', 'error', 'waiting', 
    'cancelled', 'completed') Not null default 'planned',
	task_type enum('java_action', 'manual') Not null,
	task_priority enum('low','normal','major','critical','blocker') not null,
	description varchar(250),
	process_id int(10),
	assignee_id int(10),
	expectation_start_date Datetime ,
	expectation_end_date Datetime, check(expectation_start_date <= expectation_end_date),
	start_date datetime,
	end_date datetime, check (start_date<=end_date),
	parameters varchar(4000)
);	

create Table TaskDependency
(
	task_id_from int(10),
	task_id_to int(10)

);	

create Table TaskSkill
(
	task_id int(10),
	skill_id int(10),
	skill_level numeric(1,0) not null
);

ALTER TABLE EmployeeSkill
ADD CONSTRAINT FK_EmployeeSkill_Employee
FOREIGN KEY (employee_id) REFERENCES Employee(employee_id),
Add constraint FK_EmployeeSkill_Skill
FOREIGN KEY (skill_id) REFERENCES Skill(skill_id);

ALTER TABLE ProcessTemplateRule
ADD CONSTRAINT FK_ProcessTemplateRule_ProcessTemplate
FOREIGN KEY (process_template_id) REFERENCES ProcessTemplate(process_template_id);

ALTER TABLE Process
ADD CONSTRAINT FK_Process_ProcessTemplate
FOREIGN KEY (process_template_id) REFERENCES ProcessTemplate(process_template_id);

ALTER TABLE TaskTemplateRule
ADD CONSTRAINT FK_TaskTemplateRule_TaskTemplate
FOREIGN KEY (task_template_id) REFERENCES TaskTemplate(task_template_id);

ALTER TABLE TaskDependency
ADD CONSTRAINT FK_TaskDependency_Task_From
FOREIGN KEY (task_id_from) REFERENCES Task(task_id),
ADD CONSTRAINT FK_TaskDependency_Task_To
FOREIGN KEY (task_id_to) REFERENCES Task(task_id);

ALTER TABLE TaskSkill
ADD CONSTRAINT FK_TaskSkill_Task
FOREIGN KEY (task_id) REFERENCES Task(task_id),
ADD CONSTRAINT FK_TaskSkill_Skill
FOREIGN KEY (skill_id) REFERENCES Skill(skill_id);

ALTER TABLE Task
ADD CONSTRAINT FK_Task_TaskTemplate
FOREIGN KEY (task_template_id) REFERENCES TaskTemplate(task_template_id),
ADD CONSTRAINT FK_Task_Process
FOREIGN KEY (process_id) REFERENCES Process(process_id),
ADD CONSTRAINT FK_Task_Employee
FOREIGN KEY (assignee_id) REFERENCES Employee(employee_id);