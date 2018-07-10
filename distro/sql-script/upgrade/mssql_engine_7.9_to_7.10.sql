-- https://app.camunda.com/jira/browse/CAM-9084
ALTER TABLE ACT_RE_PROCDEF
  ADD STARTABLE_ bit NOT NULL DEFAULT 1;

-- https://app.camunda.com/jira/browse/CAM-9165
create index ACT_IDX_CASE_EXEC_CASE_INST on ACT_RU_CASE_EXECUTION(CASE_INST_ID_);
