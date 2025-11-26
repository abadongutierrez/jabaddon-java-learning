package com.jabaddon.learning.java.patterns;

public class StepBuilderPatternExample {

    public static void main(String[] args) {
        System.out.println("---- Without Step Builder Pattern ----");
        DatabaseMigrationTool tool = new DatabaseMigrationTool();
        tool.setSourceDatabase("sourceHost", "sourceDB", "sourceUser", "sourcePassword");
        tool.setTargetDatabase("targetHost", "targetDB", "targetUser", "targetPassword");

        // tool.validateMigratedData(); error
        tool.createBackup();
        tool.migrateData();
        tool.validateMigratedData();

        System.out.println("---- Using Step Builder Pattern ----");
        DatabaseMigrationTool.builder()
            .fromDatabase("sourceHost", "sourceDB", "sourceUser", "sourcePassword")
            .toDatabase("targetHost", "targetDB", "targetUser", "targetPassword")
            .withBackup()
            .migrateData()
            .validateMigration()
            .finish();
    }
}

interface FirstStep {
    SecondStep fromDatabase(String host, String db, String user, String password);
}

interface SecondStep {
    ThirdStep toDatabase(String host, String db, String user, String password);
}

interface ThirdStep {
    FourthStep withBackup();
}

interface FourthStep {
    FifthStep migrateData();
}

interface FifthStep {
    FinalStep validateMigration();
}

interface FinalStep {
    void finish();
}


class DatabaseMigrationTool {
    private String sourceHost;
    private String sourceDB;
    private String sourceUser;
    private String sourcePassword;
    private String targetHost;
    private String targetDB;
    private String targetUser;
    private String targetPassword;
    private boolean backupCreated = false;
    private boolean dataTransferred = false;

    public void setSourceDatabase(String host, String db, String user, String password) {
        this.sourceHost = host;
        this.sourceDB = db;
        this.sourceUser = user;
        this.sourcePassword = password;
    }

    public void setTargetDatabase(String host, String db, String user, String password) {
        this.targetHost = host;
        this.targetDB = db;
        this.targetUser = user;
        this.targetPassword = password;
    }

    public void createBackup() {
        // Implementation details omitted for brevity
        this.backupCreated = true;

        // nullpointer exceptions if there is no source and target data defined :D
        System.out.println("Backing up database " + sourceDB + " from " + sourceHost);
    }

    public void migrateData() {
        // you cannot transfer the data if the backup wasn't created
        if (!backupCreated) throw new IllegalStateException("Hey, did you forget to backup?");

        // Implementation details omitted for brevity
        System.out.println("Migrating data from " + sourceDB + " to " + targetDB);
        this.dataTransferred = true;
    }

    public void validateMigratedData() {
        // you cannot validate copied data if the data wasn't transfered first!
        if (!dataTransferred) throw new IllegalStateException("Come on! really?!");

        System.err.println("Validating data in " + targetDB + " on " + targetHost);
    }

    // The builder!
    public static FirstStep builder() {
        return new Builder();
    }

    private static class Builder
        implements FirstStep, SecondStep, ThirdStep, FourthStep, FifthStep, FinalStep {
        private DatabaseMigrationTool tool = new DatabaseMigrationTool();

        @Override
        public SecondStep fromDatabase(String host, String db, String user, String password) {
            // Add validation here
            this.tool.setSourceDatabase(host, db, user, password);
            return this;
        }

        @Override
        public ThirdStep toDatabase(String host, String db, String user, String password) {
            // Add validation here
            this.tool.setTargetDatabase(host, db, user, password);
            return this;
        }

        @Override
        public FourthStep withBackup() {
            this.tool.createBackup();
            return this;
        }

        @Override
        public FifthStep migrateData() {
            this.tool.migrateData();
            return this;
        }

        @Override
        public FinalStep validateMigration() {
            this.tool.validateMigratedData();
            return this;
        }

        @Override
        public void finish() {
            System.out.println("Done!");
        }
    }
}
