create table MT_PayPal (
	paypalUser VARCHAR(75) null,
	paypalPassword VARCHAR(75) null,
	paypalFirm VARCHAR(75) null,
	paypalEmail VARCHAR(75) null,
	configurationId LONG not null primary key
);

create table MT_Role_Config (
	roleId LONG not null,
	configurationId LONG not null,
	primary key (roleId, configurationId)
);

create table MT_SubsConfiguration (
	configurationId LONG not null primary key,
	groupId LONG,
	description VARCHAR(75) null,
	amount DOUBLE,
	cycle VARCHAR(75) null,
	time_ INTEGER
);

create table MT_Subscription (
	subscriptionId LONG not null primary key,
	userId LONG,
	createDate DATE null,
	expireDate DATE null,
	payment DOUBLE,
	configurationId LONG,
	paypalProfile VARCHAR(75) null,
	isActive BOOLEAN
);