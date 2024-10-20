package sap.ass01.sol1.architectureTest;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.junit5.ArchTest;
import com.tngtech.archunit.junit5.AnalyzeClasses;
import com.tngtech.archunit.lang.ArchRule;

import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

@AnalyzeClasses(packages = "sap.ass01.sol1")
public class LayeredArchitectureTests {

    @ArchTest
    @Test
    void presentationShouldOnlyDependOnService() {
        JavaClasses importedClasses = new ClassFileImporter().importPackages("sap.ass01.sol1");

        ArchRule rule = classes()
                .that().resideInAPackage("..presentation..")
                .should().onlyDependOnClassesThat()
                .resideInAnyPackage("..presentation..", "..service..", "java..");

        rule.check(importedClasses);
    }

    @ArchTest
    @Test
    void serviceShouldOnlyDependOnKernelAndPersistence() {
        JavaClasses importedClasses = new ClassFileImporter().importPackages("sap.ass01.sol1");

        ArchRule rule = classes()
                .that().resideInAPackage("..service..")
                .should().onlyDependOnClassesThat()
                .resideInAnyPackage("..service..", "..kernel..", "..persistence..", "java..");

        rule.check(importedClasses);
    }

    @ArchTest
    @Test
    void persistenceShouldOnlyDependOnKernel() {
        JavaClasses importedClasses = new ClassFileImporter().importPackages("sap.ass01.sol1");

        ArchRule rule = classes()
                .that().resideInAPackage("..persistence..")
                .should().onlyDependOnClassesThat()
                .resideInAnyPackage("..persistence..", "..kernel..", "java..");

        rule.check(importedClasses);
    }

    @ArchTest
    @Test
    void kernelShouldNotDependOnOtherLayers() {
        JavaClasses importedClasses = new ClassFileImporter().importPackages("sap.ass01.sol1");

        ArchRule rule = noClasses()
                .that().resideInAPackage("..kernel..")
                .should().dependOnClassesThat()
                .resideInAnyPackage("..service..", "..persistence..", "..presentation..");

        rule.check(importedClasses);
    }
}
