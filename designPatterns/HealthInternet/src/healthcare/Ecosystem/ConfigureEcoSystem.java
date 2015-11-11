/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthcare.Ecosystem;

//import healthcare.Department.AdministratorDepartment;
import healthcare.Department.Department;
import healthcare.Department.DepartmentType;
import healthcare.Department.DoctorDepartment;
import healthcare.Department.LabDepartment;
import healthcare.Department.PharmaceuticalDrugRegulatoryDepartment;
import healthcare.Department.PharmacyDepartment;
import healthcare.Department.SocialGroup;
import healthcare.Drug.Drug;
import healthcare.Enterprise.Enterprise;
import healthcare.Enterprise.HospitalEnterprise;
import healthcare.Enterprise.PatientSocialEnterprise;
import healthcare.Enterprise.PharmaceuticalEnterprise;
import healthcare.Network.CompositeNetwork;
import healthcare.Network.HospitalNetwork;
import healthcare.Network.Network;
import healthcare.Network.PharmaceuticalCompaniesNetwork;
import healthcare.Network.SocialNetwork;
import healthcare.Person.Person;
import healthcare.Role.AdminRole;
import healthcare.Role.DoctorRole;
import healthcare.Role.FDADrugRegulator;
import healthcare.Role.LabAssistantRole;
import healthcare.Role.NurseRole;
import healthcare.Role.PatientRole;
import healthcare.Role.PharmacyRole;
import healthcare.Role.SystemAdministratorRole;
import healthcare.UserAccount.UserAccount;

/**
 *
 * @author Muddassar
 */
public class ConfigureEcoSystem {
    public static EcoSystem configure(){
        
        EcoSystem system = EcoSystem.getInstance();
        
        //Create a global Hospital network
        Network globalHealthNetwork = new CompositeNetwork();
        globalHealthNetwork.setName("Global Healthnet");
        
        system.getNetworkList().add(globalHealthNetwork);
        
        Network maNetwork = new CompositeNetwork();
        maNetwork.setName("MA");
        globalHealthNetwork.Add(maNetwork);
        Network bostonNetwork = new CompositeNetwork();
        bostonNetwork.setName("Boston");
        maNetwork.Add(bostonNetwork);
        Network bostonHealthNet = new HospitalNetwork();
        bostonHealthNet.setName("Boston Healthnet");
        bostonNetwork.Add(bostonHealthNet);
        
        
        Network txNetwork = new CompositeNetwork();
        txNetwork.setName("TX");
        globalHealthNetwork.Add(txNetwork);
        
        Network austinNetwork = new CompositeNetwork();
        austinNetwork.setName("Austin");
        txNetwork.Add(austinNetwork);
        
        Network austinHealthNet = new HospitalNetwork();
        austinHealthNet.setName("Austin Healthnet");
        austinNetwork.Add(austinHealthNet);
        
        
        //create an enterprise
        Enterprise hospital = new HospitalEnterprise("Boston General");
        Enterprise hospital1 = new HospitalEnterprise("Austin General");
        bostonHealthNet.getEnterpriseDirectory().getEnterpriseList().add(hospital);
        austinHealthNet.getEnterpriseDirectory().getEnterpriseList().add(hospital1);
        
        //initialize some departments for Boston
        
        Department bostonDoctor = hospital.getDepartmentDirectory().createOrganization(DepartmentType.Doctor);
        Department bostonPatient = hospital.getDepartmentDirectory().createOrganization(DepartmentType.Patient);
        Department bostonLab = hospital.getDepartmentDirectory().createOrganization(DepartmentType.Lab);
        Department bostonPharmacy = hospital.getDepartmentDirectory().createOrganization(DepartmentType.Pharmacy);
        Department bostonNurse = hospital.getDepartmentDirectory().createOrganization(DepartmentType.Nurse);
        
        Department auDoctor = hospital1.getDepartmentDirectory().createOrganization(DepartmentType.Doctor);
        Department auPatient = hospital1.getDepartmentDirectory().createOrganization(DepartmentType.Patient);
        Department auLab = hospital1.getDepartmentDirectory().createOrganization(DepartmentType.Lab);
        Department auPharmacy = hospital1.getDepartmentDirectory().createOrganization(DepartmentType.Pharmacy);
        Department auNurse = hospital1.getDepartmentDirectory().createOrganization(DepartmentType.Nurse);
        
        //have some employees and usernames
        Person p = hospital.createPerson("bg");
        hospital.getUserAccountDirectory().createUserAccount("bg", "bg", p, new AdminRole());
        p = bostonDoctor.createPerson("bgd1");
        bostonDoctor.getUserAccountDirectory().createUserAccount("bgd1", "bgd1", p, new DoctorRole());
        p = bostonDoctor.createPerson("bgd2");
        bostonDoctor.getUserAccountDirectory().createUserAccount("bgd2", "bgd2", p, new DoctorRole());
        p = bostonPatient.createPerson("bgp1");
        p.setSsn("SSN1");
        p = bostonPatient.createPerson("bgp2");
        p.setSsn("SSN2");
        p = bostonPatient.createPerson("bgp3");
        p.setSsn("SSN3");
        p = bostonPatient.createPerson("bgp4");
        p.setSsn("SSN4");
        p = bostonPatient.createPerson("bgp5");
        p.setSsn("SSN5");
        p = bostonPatient.createPerson("bgp6");
        p.setSsn("SSN6");
        p = bostonPatient.createPerson("bgp7");
        p.setSsn("SSN7");
        p = bostonLab.createPerson("bgl1");
        bostonLab.getUserAccountDirectory().createUserAccount("bgl1", "bgl1", p, new LabAssistantRole());
        p = bostonNurse.createPerson("bgn1");
        bostonNurse.getUserAccountDirectory().createUserAccount("bgn1", "bgn1", p, new NurseRole());
        p = bostonNurse.createPerson("bgn2");
        bostonNurse.getUserAccountDirectory().createUserAccount("bgn2", "bgn2", p, new NurseRole());
        p = bostonPharmacy.createPerson("bgph1");
        bostonPharmacy.getUserAccountDirectory().createUserAccount("bgph1", "bgph1", p, new PharmacyRole());
        
        p = hospital1.createPerson("ag");
        hospital1.getUserAccountDirectory().createUserAccount("ag", "ag", p, new AdminRole());
        p = auDoctor.createPerson("agd1");
        auDoctor.getUserAccountDirectory().createUserAccount("agd1", "agd1", p, new DoctorRole());
        p = auPatient.createPerson("agp1");
        p.setSsn("SSN1");
        p = auPatient.createPerson("agp2");
        p.setSsn("SSN2");
        p = auPatient.createPerson("agp3");
        p.setSsn("SSN3");
        p = auPatient.createPerson("agp4");
        p.setSsn("SSN4");
        p = auPatient.createPerson("agp5");
        p.setSsn("SSN5");
        p = auPatient.createPerson("agp6");
        p.setSsn("SSN6");
        p = auPatient.createPerson("agp7");
        p.setSsn("SSN7");
        p = auLab.createPerson("agl1");
        auLab.getUserAccountDirectory().createUserAccount("agl1", "agl1", p, new LabAssistantRole());
        p = auNurse.createPerson("agn1");
        auNurse.getUserAccountDirectory().createUserAccount("agn1", "agn1", p, new NurseRole());
        p = auPharmacy.createPerson("agph1");
        auPharmacy.getUserAccountDirectory().createUserAccount("agph1", "agph1", p, new PharmacyRole());
        
        
        //create user account
        
        //Create Pharmaceutical Company Network
        Network network = new PharmaceuticalCompaniesNetwork();
        network.setName("Pharmaceutical Companies");
        //Add network to system
        system.getNetworkList().add(network);
        
        //Create enterprises
        PharmaceuticalEnterprise pharmaEnterprise1 = new PharmaceuticalEnterprise("Pfizer");
        PharmaceuticalEnterprise pharmaEnterprise2 = new PharmaceuticalEnterprise("GlaxoSmithKline");
        
        //Add enterprises to the network
        network.getEnterpriseDirectory().getEnterpriseList().add(pharmaEnterprise1);
        network.getEnterpriseDirectory().getEnterpriseList().add(pharmaEnterprise2);
        
        
        //Create drug regulatory departments
        Department pharma1DrugRegulator = pharmaEnterprise1.getDepartmentDirectory().createOrganization(DepartmentType.PharmaceuticalDrugRegulatoryDepartment);
        Department pharma2DrugRegulator = pharmaEnterprise2.getDepartmentDirectory().createOrganization(DepartmentType.PharmaceuticalDrugRegulatoryDepartment);        
        
        Person ph1 = pharmaEnterprise1.createPerson("ph1");
        pharmaEnterprise1.getUserAccountDirectory().createUserAccount("ph1", "ph1", ph1, new AdminRole());
        
        ph1 = pharma1DrugRegulator.createPerson("pr1");
        pharma1DrugRegulator.getUserAccountDirectory().createUserAccount("pr1", "pr1", ph1, new FDADrugRegulator());
        
        
        //Create Drugs for pharma regulator and add it in pharmacy
        Drug drug = ((PharmaceuticalDrugRegulatoryDepartment)pharma1DrugRegulator).getDrugCatalog().addDrug("Hydrocodone");
        drug.setManufacturer(pharmaEnterprise1.getName());
        ((PharmacyDepartment)bostonPharmacy).getDrugCatalog().getDrugList().add(drug);
        
        drug = ((PharmaceuticalDrugRegulatoryDepartment)pharma1DrugRegulator).getDrugCatalog().addDrug("Xanax");
        drug.setManufacturer(pharmaEnterprise1.getName());
        ((PharmacyDepartment)bostonPharmacy).getDrugCatalog().getDrugList().add(drug);
        
        drug = ((PharmaceuticalDrugRegulatoryDepartment)pharma1DrugRegulator).getDrugCatalog().addDrug("Tramadol");
        drug.setManufacturer(pharmaEnterprise1.getName());
        ((PharmacyDepartment)bostonPharmacy).getDrugCatalog().getDrugList().add(drug);
        
        drug = ((PharmaceuticalDrugRegulatoryDepartment)pharma1DrugRegulator).getDrugCatalog().addDrug("Vicodin");
        drug.setManufacturer(pharmaEnterprise1.getName());
        ((PharmacyDepartment)bostonPharmacy).getDrugCatalog().getDrugList().add(drug);
        
        drug = ((PharmaceuticalDrugRegulatoryDepartment)pharma1DrugRegulator).getDrugCatalog().addDrug("Lyrica");
        drug.setManufacturer(pharmaEnterprise1.getName());
        ((PharmacyDepartment)bostonPharmacy).getDrugCatalog().getDrugList().add(drug);
        
        drug = ((PharmaceuticalDrugRegulatoryDepartment)pharma1DrugRegulator).getDrugCatalog().addDrug("Oxycodone");
        drug.setManufacturer(pharmaEnterprise1.getName());
        ((PharmacyDepartment)auPharmacy).getDrugCatalog().getDrugList().add(drug);
        
        drug = ((PharmaceuticalDrugRegulatoryDepartment)pharma1DrugRegulator).getDrugCatalog().addDrug("Lisinopril");
        drug.setManufacturer(pharmaEnterprise1.getName());
        ((PharmacyDepartment)auPharmacy).getDrugCatalog().getDrugList().add(drug);
        
        drug = ((PharmaceuticalDrugRegulatoryDepartment)pharma1DrugRegulator).getDrugCatalog().addDrug("Cymbalta");
        drug.setManufacturer(pharmaEnterprise1.getName());
        ((PharmacyDepartment)auPharmacy).getDrugCatalog().getDrugList().add(drug);
        
        drug = ((PharmaceuticalDrugRegulatoryDepartment)pharma1DrugRegulator).getDrugCatalog().addDrug("Lipitor");
        drug.setManufacturer(pharmaEnterprise1.getName());
        ((PharmacyDepartment)auPharmacy).getDrugCatalog().getDrugList().add(drug);
        
        drug = ((PharmaceuticalDrugRegulatoryDepartment)pharma1DrugRegulator).getDrugCatalog().addDrug("Percocet");
        drug.setManufacturer(pharmaEnterprise1.getName());
        ((PharmacyDepartment)auPharmacy).getDrugCatalog().getDrugList().add(drug);
        
        ph1 = pharmaEnterprise2.createPerson("ph2");
        pharmaEnterprise2.getUserAccountDirectory().createUserAccount("ph2", "ph2", ph1, new AdminRole());
        
        ph1 = pharma2DrugRegulator.createPerson("pr2");
        pharma2DrugRegulator.getUserAccountDirectory().createUserAccount("pr2", "pr2", ph1, new FDADrugRegulator());
        
        //Create drugs for pharma 2
        drug = ((PharmaceuticalDrugRegulatoryDepartment)pharma2DrugRegulator).getDrugCatalog().addDrug("Zoloft");
        drug.setManufacturer(pharmaEnterprise2.getName());
        ((PharmacyDepartment)bostonPharmacy).getDrugCatalog().getDrugList().add(drug);
        
        drug = ((PharmaceuticalDrugRegulatoryDepartment)pharma2DrugRegulator).getDrugCatalog().addDrug("Metformin");
        drug.setManufacturer(pharmaEnterprise2.getName());
        ((PharmacyDepartment)bostonPharmacy).getDrugCatalog().getDrugList().add(drug);
        
        drug = ((PharmaceuticalDrugRegulatoryDepartment)pharma2DrugRegulator).getDrugCatalog().addDrug("Effexor");
        drug.setManufacturer(pharmaEnterprise2.getName());
        ((PharmacyDepartment)bostonPharmacy).getDrugCatalog().getDrugList().add(drug);
        
        drug = ((PharmaceuticalDrugRegulatoryDepartment)pharma2DrugRegulator).getDrugCatalog().addDrug("Ambien");
        drug.setManufacturer(pharmaEnterprise2.getName());
        ((PharmacyDepartment)bostonPharmacy).getDrugCatalog().getDrugList().add(drug);
        
        drug = ((PharmaceuticalDrugRegulatoryDepartment)pharma2DrugRegulator).getDrugCatalog().addDrug("Prednisone");
        drug.setManufacturer(pharmaEnterprise2.getName());
        ((PharmacyDepartment)bostonPharmacy).getDrugCatalog().getDrugList().add(drug);
        
        drug = ((PharmaceuticalDrugRegulatoryDepartment)pharma2DrugRegulator).getDrugCatalog().addDrug("Atenolol");
        drug.setManufacturer(pharmaEnterprise2.getName());
        ((PharmacyDepartment)auPharmacy).getDrugCatalog().getDrugList().add(drug);
        
        drug = ((PharmaceuticalDrugRegulatoryDepartment)pharma2DrugRegulator).getDrugCatalog().addDrug("Wellbutrin");
        drug.setManufacturer(pharmaEnterprise2.getName());
        ((PharmacyDepartment)auPharmacy).getDrugCatalog().getDrugList().add(drug);
        
        drug = ((PharmaceuticalDrugRegulatoryDepartment)pharma2DrugRegulator).getDrugCatalog().addDrug("Morphine");
        drug.setManufacturer(pharmaEnterprise2.getName());
        ((PharmacyDepartment)auPharmacy).getDrugCatalog().getDrugList().add(drug);
        
        drug = ((PharmaceuticalDrugRegulatoryDepartment)pharma2DrugRegulator).getDrugCatalog().addDrug("Naproxen");
        drug.setManufacturer(pharmaEnterprise2.getName());
        ((PharmacyDepartment)auPharmacy).getDrugCatalog().getDrugList().add(drug);
        
        drug = ((PharmaceuticalDrugRegulatoryDepartment)pharma2DrugRegulator).getDrugCatalog().addDrug("Phentermine");
        drug.setManufacturer(pharmaEnterprise2.getName());
        ((PharmacyDepartment)auPharmacy).getDrugCatalog().getDrugList().add(drug);
        
        
        //Social Network
        Network socialNetwork = new SocialNetwork();
        socialNetwork.setName("Social Network");
        system.getNetworkList().add(socialNetwork);
        PatientSocialEnterprise socialEnterprise1 = new PatientSocialEnterprise("Boston Social");
        PatientSocialEnterprise socialEnterprise2 = new PatientSocialEnterprise("Austin Social");
        socialNetwork.getEnterpriseDirectory().getEnterpriseList().add(socialEnterprise1);
        socialNetwork.getEnterpriseDirectory().getEnterpriseList().add(socialEnterprise2);
        
        
        Department socialDepartment1 = socialEnterprise1.getDepartmentDirectory().createOrganization(DepartmentType.SocailGroups);
        socialDepartment1.setName("Diabetics Group");
        Department socialDepartment2 = socialEnterprise2.getDepartmentDirectory().createOrganization(DepartmentType.SocailGroups);
        socialDepartment2.setName("HyperTension Group");
        
        Person user1 = socialEnterprise1.createPerson("socialAdmin1");
        socialEnterprise1.getUserAccountDirectory().createUserAccount("sa1", "sa1", user1, new AdminRole());
        
        user1 = socialEnterprise2.createPerson("socialAdmin2");
        socialEnterprise2.getUserAccountDirectory().createUserAccount("sa2", "sa2", user1, new AdminRole());
        
        
        user1 = socialDepartment1.createPerson("user1");
        socialDepartment1.getUserAccountDirectory().createUserAccount("user1", "user1", user1, new PatientRole());
 
        user1 = socialDepartment2.createPerson("user2");
        socialDepartment2.getUserAccountDirectory().createUserAccount("user2", "user2", user1, new PatientRole());
 
        
        Person person = system.getPersonDirectory().createPerson("Muddassar Mubeen");
        
        UserAccount ua = system.getUserAccountDirectory().createUserAccount("sysadmin", "sysadmin", person, new SystemAdministratorRole());
        
        return system;
    }
        
    
}
