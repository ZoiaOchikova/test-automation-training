package Selenium.hw1.enums;

public enum PageTexts {

    TO_INCLUDE_GOOD_PRACTICES("To include good practices\nand ideas from successful\nEPAM project"),
    TO_BE_FLEXIBLE("To be flexible and\ncustomizable"),
    TO_BE_MULTIPLATFORM("To be multiplatform"),
    ALREADY_HAVEGOOD_BASE("Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…"),
    LOREM_IPSUM("LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.");

    final String text;

    PageTexts(String text){
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
