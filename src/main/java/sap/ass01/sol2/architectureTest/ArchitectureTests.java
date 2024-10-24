package sap.ass01.sol2.architectureTest;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.junit5.ArchTest;
import com.tngtech.archunit.junit5.AnalyzeClasses;
import com.tngtech.archunit.lang.ArchRule;

import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.fields;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.methods;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;
import static com.tngtech.archunit.library.dependencies.SlicesRuleDefinition.slices;

@AnalyzeClasses(packages = "sap.ass01.sol2")
public class ArchitectureTests {

    @ArchTest
    @Test
    void usecasesShouldOnlyDependOnDomainAndKernelServices() {
        JavaClasses importedClasses = new ClassFileImporter().importPackages("sap.ass01.sol2");

        ArchRule rule = classes()
                .that().resideInAPackage("..usecases..")
                .should().onlyDependOnClassesThat()
                .resideInAnyPackage("..usecases..", "..domain..", "..kernel.services..", "java..");

        rule.check(importedClasses);
    }

    @ArchTest
    @Test
    void adaptersShouldDependOnlyOnUsecasesDomainAndKernel() {
        JavaClasses importedClasses = new ClassFileImporter().importPackages("sap.ass01.sol2");

        ArchRule rule = classes()
                .that().resideInAPackage("..adapters..")
                .should().onlyDependOnClassesThat()
                .resideInAnyPackage("..adapters..", "..usecases..", "..domain..", "..kernel..", "java..");

        rule.check(importedClasses);
    }

    @ArchTest
    @Test
    void domainShouldNotDependOnUsecasesAdaptersOrKernel() {
        JavaClasses importedClasses = new ClassFileImporter().importPackages("sap.ass01.sol2");

        ArchRule rule = noClasses()
                .that().resideInAPackage("..domain..")
                .should().dependOnClassesThat()
                .resideInAnyPackage("..usecases..", "..adapters..", "..kernel..");

        rule.check(importedClasses);
    }

    @ArchTest
    @Test
    void kernelShouldNotDependOnUsecasesOrAdapters() {
        JavaClasses importedClasses = new ClassFileImporter().importPackages("sap.ass01.sol2");

        ArchRule rule = noClasses()
                .that().resideInAPackage("..kernel..")
                .should().dependOnClassesThat()
                .resideInAnyPackage("..usecases..", "..adapters..");

        rule.check(importedClasses);
    }

    @ArchTest
    @Test
    void shouldNotHaveCyclicDependenciesBetweenPackages() {
        JavaClasses importedClasses = new ClassFileImporter().importPackages("sap.ass01.sol2");

        ArchRule rule = slices().matching("sap.ass01.(*)..")
                .should().beFreeOfCycles();

        rule.check(importedClasses);
    }

    @ArchTest
    @Test
    void servicesShouldResideInKernelPackage() {
        JavaClasses importedClasses = new ClassFileImporter().importPackages("sap.ass01.sol2");

        ArchRule rule = classes()
                .that().haveSimpleNameEndingWith("Service")
                .should().resideInAPackage("..kernel.services..");

        rule.check(importedClasses);
    }

    @ArchTest
    @Test
    void controllersShouldResideInAdaptersPackage() {
        JavaClasses importedClasses = new ClassFileImporter().importPackages("sap.ass01.sol2");

        ArchRule rule = classes()
                .that().haveSimpleNameEndingWith("Controller")
                .should().resideInAPackage("..adapters..");

        rule.check(importedClasses);
    }

    @ArchTest
    @Test
    void repositoriesShouldOnlyBeAccessedFromDomainOrKernel() {
        JavaClasses importedClasses = new ClassFileImporter().importPackages("sap.ass01.sol2");

        ArchRule rule = classes()
                .that().resideInAPackage("..domain.repositories..")
                .should().onlyBeAccessed().byClassesThat()
                .resideInAnyPackage("..domain..", "..kernel..");

        rule.check(importedClasses);
    }

    @ArchTest
    @Test
    void fieldsShouldNotBePublic() {
        JavaClasses importedClasses = new ClassFileImporter().importPackages("sap.ass01.sol2");

        ArchRule rule = fields()
                .that().areDeclaredInClassesThat().resideInAPackage("..domain..")
                .should().notBePublic();

        rule.check(importedClasses);
    }

    @ArchTest
    @Test
    void methodsInUsecasesShouldNotThrowGenericExceptions() {
        JavaClasses importedClasses = new ClassFileImporter().importPackages("sap.ass01.sol2");

        ArchRule rule = methods()
                .that().areDeclaredInClassesThat().resideInAPackage("..usecases..")
                .should().notThrowExceptionOfType(Exception.class);

        rule.check(importedClasses);
    }

    @ArchTest
    @Test
    void domainClassesShouldBeIndependent() {
        JavaClasses importedClasses = new ClassFileImporter().importPackages("sap.ass01.sol2");

        ArchRule rule = noClasses()
                .that().resideInAPackage("..domain..")
                .should().accessClassesThat().resideInAnyPackage("..adapters..",
                        "..usecases..");

        rule.check(importedClasses);
    }

    @ArchTest
    @Test
    void noClassesShouldUseFieldInjection() {
        JavaClasses importedClasses = new ClassFileImporter().importPackages("sap.ass01.sol2");

        ArchRule rule = fields()
                .should().notBeAnnotatedWith("org.springframework.beans.factory.annotation.Autowired");

        rule.check(importedClasses);
    }

    @ArchTest
    @Test
    void onlyControllersShouldUseRestControllerAnnotation() {
        JavaClasses importedClasses = new ClassFileImporter().importPackages("sap.ass01.sol2");

        ArchRule rule = classes()
                .that().areAnnotatedWith("org.springframework.web.bind.annotation.RestController")
                .should().resideInAPackage("..adapters..");

        rule.check(importedClasses);
    }
}
