CREATE TABLE Address (
    id BIGINT NOT NULL AUTO_INCREMENT,
    firstLine VARCHAR(100) NOT NULL,
    secondLine VARCHAR(100),
    city VARCHAR(30) NOT NULL,
    state VARCHAR(30) NOT NULL,
    pincode CHAR(6) NOT NULL,
    phoneNumber VARCHAR(20),
    PRIMARY KEY (id)
);

CREATE TABLE Entity (
    id BIGINT NOT NULL AUTO_INCREMENT,
    creationTime TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    name VARCHAR(100) NOT NULL,
    displayName VARCHAR(100),
    type CHAR(20),
    addressId BIGINT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (addressId) REFERENCES Address(id)
);

CREATE TABLE Agent (
    id BIGINT NOT NULL AUTO_INCREMENT,
    creationTime TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    email VARCHAR(100),
    loginId CHAR(15) NOT NULL,
    hashedPassword VARCHAR(50) NOT NULL,
    role CHAR(40),
    dateOfBirth TIMESTAMP NOT NULL,
    firstName VARCHAR(25) NOT NULL,
    lastName VARCHAR(25),
    addressId BIGINT,
    PRIMARY KEY (id),
    FOREIGN KEY (addressId) REFERENCES Address(id)
);

CREATE TABLE CallInfo (
    id BIGINT NOT NULL AUTO_INCREMENT,
    creationTime TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    customerName VARCHAR(50) NOT NULL,
    lastUpdatedTime TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    currentStatus CHAR(40) NOT NULL,
    assignedEntityId BIGINT NOT NULL,
    assignedAgentId BIGINT,
    lastStatusChangeId BIGINT,
    priority TINYINT DEFAULT -1,
    addressId BIGINT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (assignedEntityId) REFERENCES Entity(id),
    FOREIGN KEY (addressId) REFERENCES Address(id)
);

CREATE TABLE CallStatusChange (
    id BIGINT NOT NULL AUTO_INCREMENT,
    creationTime TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    oldStatus CHAR(20),
    newStatus CHAR(20),
    changedByAgentId BIGINT NOT NULL,
    callInfoId BIGINT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (changedByAgentId) REFERENCES Agent(id),
    FOREIGN KEY (callInfoId) REFERENCES CallInfo(id)
);

CREATE TABLE EntityAgentMapping (
    entityId BIGINT NOT NULL,
    agentId BIGINT NOT NULL,
    PRIMARY KEY (entityId, agentId),
    CONSTRAINT FOREIGN KEY (entityId) REFERENCES Entity(id),
    CONSTRAINT FOREIGN KEY (agentId) REFERENCES Agent(id)
);

SHOW TABLES;
