create index IX_1D2A2FB3 on MT_Message (companyId);
create index IX_9E0D08F on MT_Message (userId);

create index IX_D0633C30 on MT_PayPal (configurationId);

create index IX_84BFF328 on MT_Role_Config (configurationId);

create index IX_A60E35F9 on MT_SubsConfiguration (groupId);

create index IX_90AEBA6 on MT_Subscription (configurationId);
create index IX_4F962495 on MT_Subscription (userId);