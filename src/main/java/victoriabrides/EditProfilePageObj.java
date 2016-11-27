package victoriabrides;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by ASUS PC on 27.11.2016.
 */
public class EditProfilePageObj extends ActionWithWebelement {

    //NB все данные пишу на 2теста, тоесть +ещелокаторы с другими данными
    public EditProfilePageObj(WebDriver driver){
        super(driver);
    }

    //блк №1 персональные данные имя, дата рождения
    private By menuButton = By.id("email");
    private By myPrifileLink = By.id("email");
    private By buttonEditNameBirth = By.id("email");
    private By fieldName = By.id("email");
    private By fieldBirthDay = By.id("email");
    private By birthDay22 = By.id("email");
    private By fieldBirthMonth = By.id("email");
    private By birthMonthJune = By.id("email");
    private By fieldBirthYear = By.id("email");
    private By birthYear1986 = By.id("email");
    private By butSaveNameBith = By.id("email");
    private By butCancelNameBith = By.id("email");

    //блк №2 About me
    private By buttonEditAboutMe = By.id("email");
    private By fieldCountry = By.id("email");
    private By countryUK = By.id("email");
    private By city = By.id("email");
    private By fieldYourHeigh = By.id("email");
    private By findYourHeigh = By.id("email");
    private By yourHeigh = By.id("email");
    private By fieldYourBoduType = By.id("email");
    private By findYourBoduType = By.id("email");
    private By yourBoduType = By.id("email");
    private By fieldYourMeritalStatus = By.id("email");
    private By yourMeritalStatus = By.id("email");
    private By fieldYourAmountChildren = By.id("email");
    private By yourAmountChildren = By.id("email");
    private By fieldMoreChild = By.id("email");
    private By moreChild = By.id("email");
    private By fieldYourEducation = By.id("email");
    private By yourEducation = By.id("email");
    private By fieldYourReligion = By.id("email");
    private By yourReligion = By.id("email");
    private By fieldDrink = By.id("email");
    private By drink = By.id("email");
    private By fieldSmoke = By.id("email");
    private By smoke = By.id("email");
    private By fieldOccupation = By.id("email");
    private By occupation = By.id("email");
    private By fieldInfoAboutYourself = By.id("email");
    private By InfoAboutYourself = By.id("email");
    private By butSaveAboutMe = By.id("email");
    private By butCancelAboutMe = By.id("email");


    //блк №3 About my date
    private By buttonEditAboutMyDate = By.id("email");
    private By reasonToJoinVBMerriage = By.id("email");
    private By fieldFgeFrom = By.id("email");
    private By ageFrom20 = By.id("email");
    private By fieldAgeTo = By.id("email");
    private By ageTo50 = By.id("email");
    private By fieldHerAmountChildren = By.id("email");
    private By herNoChildren = By.id("email");
    private By fieldSheMoreChild = By.id("email");
    private By sheWantSomedayChild = By.id("email");
    private By fieldHerHeighFrom = By.id("email");
    private By herHeighFrom130 = By.id("email");
    private By fieldHerHeighTo = By.id("email");
    private By herHeighTo210 = By.id("email");
    private By fieldHerWeightFrom = By.id("email");
    private By herWeightFrom40 = By.id("email");
    private By fieldHerWeightTo = By.id("email");
    private By herWeightTo210 = By.id("email");
    private By herBodyTypeSlim = By.id("email");
    private By fieldSheDrink = By.id("email");
    private By drinkOften = By.id("email");
    private By fieldSheSmoke = By.id("email");
    private By smokeSocially = By.id("email");
    private By butSaveAboutMyDate = By.id("email");
    private By butCancelAboutMyDate = By.id("email");

    //блок №4 My photo
    private By linkUploadPhoto = By.id("email");
    private By LinkAddMorePhoto = By.id("email");
    private By buttonFinish = By.id("email");
    private By buttonDelatePhoto = By.id("email");



}
