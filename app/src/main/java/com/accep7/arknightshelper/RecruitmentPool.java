package com.accep7.arknightshelper;

import java.util.ArrayList;
import java.util.List;

class RecruitmentPool {

    //region Filtering parameters and operator properties
    protected final static String QUALIFICATION_STARTER = "Starter";
    protected final static String QUALIFICATION_SENIOR = "Senior Operator";
    protected final static String QUALIFICATION_TOP = "Top Operator";

    protected final static String ATTACK_TYPE_MELEE = "Melee";
    protected final static String ATTACK_TYPE_RANGED = "Ranged";

    protected final static String CLASS_GUARD = "Guard";
    protected final static String CLASS_SPECIALIST = "Specialist";
    protected final static String CLASS_SNIPER = "Sniper";
    protected final static String CLASS_CASTER = "Caster";
    protected final static String CLASS_DEFENDER = "Defender";
    protected final static String CLASS_MEDIC = "Medic";
    protected final static String CLASS_VANGUARD = "Vanguard";
    protected final static String CLASS_SUPPORTER = "Supporter";

    protected final static String TYPE_GUARD_DREADNOUGHT = "Dreadnought";
    protected final static String TYPE_GUARD_INSTRUCTOR = "Instructor";
    protected final static String TYPE_GUARD_FIGHTER = "Fighter";
    protected final static String TYPE_GUARD_ARTS_FIGHTER = "Arts Fighter";
    protected final static String TYPE_GUARD_LORD = "Lord";
    protected final static String TYPE_GUARD_CENTURION = "Centurion";
    protected final static String TYPE_GUARD_MUSHA = "Musha ";
    protected final static String TYPE_GUARD_SWORDMASTER = "Swordmaster";
    //protected final static String TYPE_LIBERATOR_GUARD = "Liberator";
    //protected final static String TYPE_REAPER_GUARD = "Reaper";

    protected final static String TYPE_SPECIALIST_AMBUSHER = "Ambusher";
    protected final static String TYPE_SPECIALIST_HOOKMASTER = "Hookmaster";
    protected final static String TYPE_SPECIALIST_PUSH_STROKER = "Push Stroker";
    protected final static String TYPE_SPECIALIST_EXECUTOR = "Executor";
    protected final static String TYPE_SPECIALIST_GEEK = "Geek";
    //protected final static String TYPE_SPECIALIST_DOLLKEEPER = "Dollkeeper";
    //protected final static String TYPE_SPECIALIST_TRAPMASTER = "Trapmaster";
    //protected final static String TYPE_SPECIALIST_MERCHANT = "Merchant";

    protected final static String TYPE_SNIPER_DEADEYE = "Deadeye";
    protected final static String TYPE_SNIPER_SPREADSHOOTER = "Spreadshooter";
    protected final static String TYPE_SNIPER_ARTILLERYMAN = "Artilleryman";
    protected final static String TYPE_SNIPER_MARKSMAN = "Marksman";
    protected final static String TYPE_SNIPER_HEAVYSHOOTER = "Heavyshooter";
    //protected final static String TYPE_SNIPER_FLINGER = "Flinger";
    //protected final static String TYPE_SNIPER_Besieger = "Besieger";

    protected final static String TYPE_CASTER_SPLASH = "Splash";
    protected final static String TYPE_CASTER_CORE = "Core";
    protected final static String TYPE_CASTER_BLAST = "Blast";
    //protected final static String TYPE_CASTER_MYSTIC = "Mystic";
    //protected final static String TYPE_CASTER_MECH_ACCORD = "Mech-accord";
    //protected final static String TYPE_CASTER_PHALANX = "Phalanx";
    //protected final static String TYPE_CASTER_CHAIN = "Chain";

    protected final static String TYPE_DEFENDER_JUGGERNAUT = "Juggernaut";
    protected final static String TYPE_DEFENDER_GUARDIAN = "Guardian";
    protected final static String TYPE_DEFENDER_PROTECTOR = "Protector";
    //protected final static String TYPE_DEFENDER_DUELIST = "Duelist";
    //protected final static String TYPE_DEFENDER_ARTS = "Arts Protector";
    //protected final static String TYPE_DEFENDER_FORTRESS = "Fortress";

    protected final static String TYPE_MEDIC_ST = "Single-target";
    protected final static String TYPE_MEDIC_MULTITARGET = "Multi-target";
    //protected final static String TYPE_MEDIC_WANDERING = "Wandering";
    //protected final static String TYPE_MEDIC_THERAPIST = "Therapist";

    protected final static String TYPE_VANGUARD_PIONEER = "Pioneer";
    protected final static String TYPE_VANGUARD_STANDARD_BEARER = "Standard Bearer";
    protected final static String TYPE_VANGUARD_CHARGER = "Charger";
    //protected final static String TYPE_VANGUARD_TACTICIAN = "Tactician";

    protected final static String TYPE_SUPPORTER_HEXER = "Hexer";
    protected final static String TYPE_SUPPORTER_DECEL_BINDER = "Decel Binder";
    protected final static String TYPE_SUPPORTER_SUMMONER = "Summoner";
    //protected final static String TYPE_SUPPORTER_BARD = "Bard";
    //protected final static String TYPE_SUPPORTER_ABJURER = "Abjurer";
    //protected final static String TYPE_SUPPORTER_ARTIFICER = "Artificer";

    protected final static String AFFIX_HEALING = "Healing";
    protected final static String AFFIX_DEFENSE = "Defense";
    protected final static String AFFIX_SLOW = "Slow";
    protected final static String AFFIX_DP_RECOVERY = "DP-Recovery";
    protected final static String AFFIX_AOE = "AoE";
    protected final static String AFFIX_DPS = "DPS";
    protected final static String AFFIX_SURVIVAL = "Survival";
    protected final static String AFFIX_SHIFT = "Shift";
    protected final static String AFFIX_SUPPORT = "Support";
    protected final static String AFFIX_DEBUFF = "Debuff";
    protected final static String AFFIX_FAST_REDEPLOY = "Fast-Redeploy";
    protected final static String AFFIX_ROBOT = "Robot";
    protected final static String AFFIX_SUMMON = "Summon";
    protected final static String AFFIX_CROWD_CONTROL = "Crowd-Control";
    protected final static String AFFIX_NUKER = "Nuker";
    //endregion

    /* The RecruitmentPool ArrayList, that contains all of the current global server operators in recruitment pool.
     * When in-game recruitment pool updates, simply add a new RecruitableOperator to this ArrayList and assign its in-game attributes */
    static List<RecruitableOperator> recruitableOperators = new ArrayList<>();

    static {
        // 1-star rarity
        recruitableOperators.add(new RecruitableOperator("Lancet-2", ATTACK_TYPE_RANGED, null, 1, TYPE_MEDIC_ST, CLASS_MEDIC, AFFIX_HEALING, AFFIX_ROBOT, null, R.drawable.type_medic_st, R.drawable.class_medic, R.drawable.one_star_castle));
        recruitableOperators.add(new RecruitableOperator("Castle-3", ATTACK_TYPE_MELEE, null, 1, TYPE_GUARD_DREADNOUGHT, CLASS_GUARD, AFFIX_SUPPORT, AFFIX_ROBOT, null, R.drawable.type_guard_dreadnought, R.drawable.class_guard, R.drawable.one_star_castle));
        recruitableOperators.add(new RecruitableOperator("THRM-EX", ATTACK_TYPE_MELEE, null, 1, TYPE_SPECIALIST_EXECUTOR, CLASS_SPECIALIST, AFFIX_NUKER, AFFIX_ROBOT, null, R.drawable.type_specialist_executor, R.drawable.class_specialist, R.drawable.one_star_thermal_ex));
        recruitableOperators.add(new RecruitableOperator("'Justice Knight'", ATTACK_TYPE_RANGED, null, 1, TYPE_SNIPER_MARKSMAN, CLASS_SNIPER, AFFIX_SUPPORT, AFFIX_ROBOT, null, R.drawable.type_sniper_marksman, R.drawable.class_sniper, R.drawable.one_star_jk));

        // 2-star rarity
        recruitableOperators.add(new RecruitableOperator("12F", ATTACK_TYPE_RANGED, QUALIFICATION_STARTER, 2, TYPE_CASTER_SPLASH, CLASS_CASTER, null, null, null, R.drawable.type_caster_splash, R.drawable.class_caster, R.drawable.two_star_twelvef));
        recruitableOperators.add(new RecruitableOperator("Durin", ATTACK_TYPE_RANGED, QUALIFICATION_STARTER, 2, TYPE_CASTER_CORE, CLASS_CASTER, null, null, null, R.drawable.type_caster_core, R.drawable.class_caster, R.drawable.two_star_durin));
        recruitableOperators.add(new RecruitableOperator("Rangers", ATTACK_TYPE_RANGED, QUALIFICATION_STARTER, 2, TYPE_SNIPER_MARKSMAN, CLASS_SNIPER, null, null, null, R.drawable.type_sniper_marksman, R.drawable.class_sniper, R.drawable.two_star_rangers));
        recruitableOperators.add(new RecruitableOperator("Noir Corne", ATTACK_TYPE_MELEE, QUALIFICATION_STARTER, 2, TYPE_DEFENDER_PROTECTOR, CLASS_DEFENDER, null, null, null, R.drawable.type_defender_protector, R.drawable.class_defender, R.drawable.two_star_noir_corne));
        recruitableOperators.add(new RecruitableOperator("Yato", ATTACK_TYPE_MELEE, QUALIFICATION_STARTER, 2, TYPE_VANGUARD_PIONEER, CLASS_VANGUARD, null, null, null, R.drawable.type_vanguard_pioneer, R.drawable.class_vanguard, R.drawable.two_star_yato));

        // 3-star rarity
        recruitableOperators.add(new RecruitableOperator("Popukar", ATTACK_TYPE_MELEE, null, 3, TYPE_GUARD_CENTURION, CLASS_GUARD, AFFIX_AOE, AFFIX_SURVIVAL, null, R.drawable.type_guard_centurion, R.drawable.class_guard, R.drawable.three_star_popukar));
        recruitableOperators.add(new RecruitableOperator("Spot", ATTACK_TYPE_MELEE, null, 3, TYPE_DEFENDER_GUARDIAN, CLASS_DEFENDER, AFFIX_HEALING, AFFIX_DEFENSE, null, R.drawable.type_defender_guardian, R.drawable.class_defender, R.drawable.three_star_spot));
        recruitableOperators.add(new RecruitableOperator("Midnight", ATTACK_TYPE_MELEE, null, 3, TYPE_GUARD_LORD, CLASS_GUARD, AFFIX_DPS, null, null, R.drawable.type_guard_lord, R.drawable.class_guard, R.drawable.three_star_midnight));
        recruitableOperators.add(new RecruitableOperator("Catapult", ATTACK_TYPE_RANGED, null, 3, TYPE_SNIPER_ARTILLERYMAN, CLASS_SNIPER, AFFIX_AOE, null, null, R.drawable.type_sniper_artilleryman, R.drawable.class_sniper, R.drawable.three_star_catapult));
        recruitableOperators.add(new RecruitableOperator("Orchid", ATTACK_TYPE_RANGED, null, 3, TYPE_SUPPORTER_DECEL_BINDER, CLASS_SUPPORTER, AFFIX_SLOW, null, null, R.drawable.type_supporter_decelbinder, R.drawable.class_supporter, R.drawable.three_star_orchid));
        recruitableOperators.add(new RecruitableOperator("Steward", ATTACK_TYPE_RANGED, null, 3, TYPE_CASTER_CORE, CLASS_CASTER, AFFIX_DPS, null, null, R.drawable.type_caster_core, R.drawable.class_caster, R.drawable.three_star_steward));
        recruitableOperators.add(new RecruitableOperator("Ansel", ATTACK_TYPE_RANGED, null, 3, TYPE_MEDIC_ST, CLASS_MEDIC, AFFIX_HEALING, null, null, R.drawable.type_medic_st, R.drawable.class_medic, R.drawable.three_star_ansel));
        recruitableOperators.add(new RecruitableOperator("Hibiscus", ATTACK_TYPE_RANGED, null, 3, TYPE_MEDIC_ST, CLASS_MEDIC, AFFIX_HEALING, null, null, R.drawable.type_medic_st, R.drawable.class_medic, R.drawable.three_star_hibiscus));
        recruitableOperators.add(new RecruitableOperator("Lava", ATTACK_TYPE_RANGED, null, 3, TYPE_CASTER_SPLASH, CLASS_CASTER, AFFIX_AOE, null, null, R.drawable.type_caster_splash, R.drawable.class_caster, R.drawable.three_star_lava));
        recruitableOperators.add(new RecruitableOperator("Adnachiel", ATTACK_TYPE_RANGED, null, 3, TYPE_SNIPER_MARKSMAN, CLASS_SNIPER, AFFIX_DPS, null, null, R.drawable.type_sniper_marksman, R.drawable.class_sniper, R.drawable.three_star_adnachiel));
        recruitableOperators.add(new RecruitableOperator("Kroos", ATTACK_TYPE_RANGED, null, 3, TYPE_SNIPER_MARKSMAN, CLASS_SNIPER, AFFIX_DPS, null, null, R.drawable.type_sniper_marksman, R.drawable.class_sniper, R.drawable.three_star_kroos));
        recruitableOperators.add(new RecruitableOperator("Beagle", ATTACK_TYPE_MELEE, null, 3, TYPE_DEFENDER_PROTECTOR, CLASS_DEFENDER, AFFIX_DEFENSE, null, null, R.drawable.type_defender_protector, R.drawable.class_defender, R.drawable.three_star_beagle));
        recruitableOperators.add(new RecruitableOperator("Melantha", ATTACK_TYPE_MELEE, null, 3, TYPE_GUARD_DREADNOUGHT, CLASS_GUARD, AFFIX_DPS, AFFIX_SURVIVAL, null, R.drawable.type_guard_dreadnought, R.drawable.class_guard, R.drawable.three_star_melantha));
        recruitableOperators.add(new RecruitableOperator("Plume", ATTACK_TYPE_MELEE, null, 3, TYPE_VANGUARD_CHARGER, CLASS_VANGUARD, AFFIX_DPS, AFFIX_DP_RECOVERY, null, R.drawable.type_vanguard_charger, R.drawable.class_vanguard, R.drawable.three_star_plume));
        recruitableOperators.add(new RecruitableOperator("Vanilla", ATTACK_TYPE_MELEE, null, 3, TYPE_VANGUARD_PIONEER, CLASS_VANGUARD, AFFIX_DP_RECOVERY, null, null, R.drawable.type_vanguard_pioneer, R.drawable.class_vanguard, R.drawable.three_star_vanilla));
        recruitableOperators.add(new RecruitableOperator("Fang", ATTACK_TYPE_MELEE, null, 3, TYPE_VANGUARD_PIONEER, CLASS_VANGUARD, AFFIX_DP_RECOVERY, null, null, R.drawable.type_vanguard_pioneer, R.drawable.class_vanguard, R.drawable.three_star_fang));

        // 4-star rarity
        recruitableOperators.add(new RecruitableOperator("May", ATTACK_TYPE_RANGED, null, 4, TYPE_SNIPER_MARKSMAN, CLASS_SNIPER, AFFIX_DPS, AFFIX_SLOW, null, R.drawable.type_sniper_marksman, R.drawable.class_sniper, R.drawable.four_star_may));
        recruitableOperators.add(new RecruitableOperator("Vermeil", ATTACK_TYPE_RANGED, null, 4, TYPE_SNIPER_MARKSMAN, CLASS_SNIPER, AFFIX_DPS, null, null, R.drawable.type_sniper_marksman, R.drawable.class_sniper, R.drawable.four_star_vermeil));
        recruitableOperators.add(new RecruitableOperator("Myrtle", ATTACK_TYPE_MELEE, null, 4, TYPE_VANGUARD_STANDARD_BEARER, CLASS_VANGUARD, AFFIX_DP_RECOVERY, AFFIX_HEALING, null, R.drawable.type_vanguard_standardbearer, R.drawable.class_vanguard, R.drawable.four_star_myrtle));
        recruitableOperators.add(new RecruitableOperator("Greyy", ATTACK_TYPE_RANGED, null, 4, TYPE_CASTER_SPLASH, CLASS_CASTER, AFFIX_AOE, AFFIX_SLOW, null, R.drawable.type_caster_splash, R.drawable.class_caster, R.drawable.four_star_greyy));
        recruitableOperators.add(new RecruitableOperator("Sussuro", ATTACK_TYPE_RANGED, null, 4, TYPE_MEDIC_ST, CLASS_MEDIC, AFFIX_HEALING, null, null, R.drawable.type_medic_st, R.drawable.class_medic, R.drawable.four_star_sussurro));
        recruitableOperators.add(new RecruitableOperator("Beehunter", ATTACK_TYPE_MELEE, null, 4, TYPE_GUARD_FIGHTER, CLASS_GUARD, AFFIX_DPS, null, null, R.drawable.type_guard_fighter, R.drawable.class_guard, R.drawable.four_star_beehunter));
        recruitableOperators.add(new RecruitableOperator("Shaw", ATTACK_TYPE_MELEE, null, 4, TYPE_SPECIALIST_PUSH_STROKER, CLASS_SPECIALIST, AFFIX_SHIFT, null, null, R.drawable.type_specialist_push_stroker, R.drawable.class_specialist, R.drawable.four_star_shaw));
        recruitableOperators.add(new RecruitableOperator("Earthspirit", ATTACK_TYPE_RANGED, null, 4, TYPE_SUPPORTER_DECEL_BINDER, CLASS_SUPPORTER, AFFIX_SLOW, null, null, R.drawable.type_supporter_decelbinder, R.drawable.class_supporter, R.drawable.four_star_earthspirit));
        recruitableOperators.add(new RecruitableOperator("Gummy", ATTACK_TYPE_MELEE, null, 4, TYPE_DEFENDER_GUARDIAN, CLASS_DEFENDER, AFFIX_DEFENSE, AFFIX_HEALING, null, R.drawable.type_defender_guardian, R.drawable.class_defender, R.drawable.four_star_gummy));
        recruitableOperators.add(new RecruitableOperator("Cuora", ATTACK_TYPE_MELEE, null, 4, TYPE_DEFENDER_PROTECTOR, CLASS_DEFENDER, AFFIX_DEFENSE, null, null, R.drawable.type_defender_protector, R.drawable.class_defender, R.drawable.four_star_cuora));
        recruitableOperators.add(new RecruitableOperator("Matterhorn", ATTACK_TYPE_MELEE, null, 4, TYPE_DEFENDER_PROTECTOR, CLASS_DEFENDER, AFFIX_DEFENSE, null, null, R.drawable.type_defender_protector, R.drawable.class_defender, R.drawable.four_star_matterhorn));
        recruitableOperators.add(new RecruitableOperator("Perfumer", ATTACK_TYPE_RANGED, null, 4, TYPE_MEDIC_MULTITARGET, CLASS_MEDIC, AFFIX_HEALING, null, null, R.drawable.type_medic_multitarget, R.drawable.class_medic, R.drawable.four_star_perfumer));
        recruitableOperators.add(new RecruitableOperator("Myrrh", ATTACK_TYPE_RANGED, null, 4, TYPE_MEDIC_ST, CLASS_MEDIC, AFFIX_HEALING, null, null, R.drawable.type_medic_st, R.drawable.class_medic, R.drawable.four_star_myrrh));
        recruitableOperators.add(new RecruitableOperator("Rope", ATTACK_TYPE_MELEE, null, 4, TYPE_SPECIALIST_HOOKMASTER, CLASS_SPECIALIST, AFFIX_SHIFT, null, null, R.drawable.type_specialist_hookmaster, R.drawable.class_specialist, R.drawable.four_star_rope));
        recruitableOperators.add(new RecruitableOperator("Gravel", ATTACK_TYPE_MELEE, null, 4, TYPE_SPECIALIST_EXECUTOR, CLASS_SPECIALIST, AFFIX_DEFENSE, AFFIX_FAST_REDEPLOY, null, R.drawable.type_specialist_executor, R.drawable.class_specialist, R.drawable.four_star_gravel));
        recruitableOperators.add(new RecruitableOperator("Mousse", ATTACK_TYPE_MELEE, null, 4, TYPE_GUARD_ARTS_FIGHTER, CLASS_GUARD, AFFIX_DPS, null, null, R.drawable.type_guard_arts_fighter, R.drawable.class_guard, R.drawable.four_star_mousse));
        recruitableOperators.add(new RecruitableOperator("Estelle", ATTACK_TYPE_MELEE, null, 4, TYPE_GUARD_CENTURION, CLASS_GUARD, AFFIX_AOE, AFFIX_SURVIVAL, null, R.drawable.type_guard_centurion, R.drawable.class_guard, R.drawable.four_star_estelle));
        recruitableOperators.add(new RecruitableOperator("Frostleaf", ATTACK_TYPE_MELEE, null, 4, TYPE_GUARD_LORD, CLASS_GUARD, AFFIX_DPS, AFFIX_SLOW, null, R.drawable.type_guard_lord, R.drawable.class_guard, R.drawable.four_star_frostleaf));
        recruitableOperators.add(new RecruitableOperator("Matoimaru", ATTACK_TYPE_MELEE, null, 4, TYPE_GUARD_DREADNOUGHT, CLASS_GUARD, AFFIX_DPS, AFFIX_SURVIVAL, null, R.drawable.type_guard_dreadnought, R.drawable.class_guard, R.drawable.four_star_matoimaru));
        recruitableOperators.add(new RecruitableOperator("Dobermann", ATTACK_TYPE_MELEE, null, 4, TYPE_GUARD_INSTRUCTOR, CLASS_GUARD, AFFIX_DPS, AFFIX_SUPPORT, null, R.drawable.type_guard_instructor, R.drawable.class_guard, R.drawable.four_star_dobermann));
        recruitableOperators.add(new RecruitableOperator("Vigna", ATTACK_TYPE_MELEE, null, 4, TYPE_VANGUARD_CHARGER, CLASS_VANGUARD, AFFIX_DPS, AFFIX_DP_RECOVERY, null, R.drawable.type_vanguard_charger, R.drawable.class_vanguard, R.drawable.four_star_vigna));
        recruitableOperators.add(new RecruitableOperator("Scavenger", ATTACK_TYPE_MELEE, null, 4, TYPE_VANGUARD_PIONEER, CLASS_VANGUARD, AFFIX_DPS, AFFIX_DP_RECOVERY, null, R.drawable.type_vanguard_pioneer, R.drawable.class_vanguard, R.drawable.four_star_scavenger));
        recruitableOperators.add(new RecruitableOperator("Shirayuki", ATTACK_TYPE_RANGED, null, 4, TYPE_SNIPER_ARTILLERYMAN, CLASS_SNIPER, AFFIX_AOE, AFFIX_SLOW, null, R.drawable.type_sniper_artilleryman, R.drawable.class_sniper, R.drawable.four_star_shirayuki));
        recruitableOperators.add(new RecruitableOperator("Meteor", ATTACK_TYPE_RANGED, null, 4, TYPE_SNIPER_MARKSMAN, CLASS_SNIPER, AFFIX_DPS, AFFIX_DEBUFF, null, R.drawable.type_sniper_marksman, R.drawable.class_sniper, R.drawable.four_star_meteor));
        recruitableOperators.add(new RecruitableOperator("Jessica", ATTACK_TYPE_RANGED, null, 4, TYPE_SNIPER_MARKSMAN, CLASS_SNIPER, AFFIX_DPS, AFFIX_SURVIVAL, null, R.drawable.type_sniper_marksman, R.drawable.class_sniper, R.drawable.four_star_jessica));
        recruitableOperators.add(new RecruitableOperator("Gitano", ATTACK_TYPE_RANGED, null, 4, TYPE_CASTER_SPLASH, CLASS_CASTER, AFFIX_AOE, null, null, R.drawable.type_caster_splash, R.drawable.class_caster, R.drawable.four_star_gitano));
        recruitableOperators.add(new RecruitableOperator("Haze", ATTACK_TYPE_RANGED, null, 4, TYPE_CASTER_CORE, CLASS_CASTER, AFFIX_DPS, AFFIX_DEBUFF, null, R.drawable.type_caster_core, R.drawable.class_caster, R.drawable.four_star_haze));
        recruitableOperators.add(new RecruitableOperator("Ambriel", ATTACK_TYPE_RANGED, null, 4, TYPE_SNIPER_DEADEYE, CLASS_SNIPER, AFFIX_DPS, AFFIX_SLOW, null, R.drawable.type_sniper_deadeye, R.drawable.class_sniper, R.drawable.four_star_ambriel));

        // 5-star rarity
        recruitableOperators.add(new RecruitableOperator("Waai Fu", ATTACK_TYPE_MELEE, QUALIFICATION_SENIOR, 5, TYPE_SPECIALIST_EXECUTOR, CLASS_SPECIALIST, AFFIX_FAST_REDEPLOY, AFFIX_DEBUFF, null, R.drawable.type_specialist_executor, R.drawable.class_specialist, R.drawable.five_star_waai_fu));
        recruitableOperators.add(new RecruitableOperator("Executor", ATTACK_TYPE_RANGED, QUALIFICATION_SENIOR, 5, TYPE_SNIPER_SPREADSHOOTER, CLASS_SNIPER, AFFIX_AOE, null, null, R.drawable.type_sniper_spreadshooter, R.drawable.class_sniper, R.drawable.five_star_executor));
        recruitableOperators.add(new RecruitableOperator("Astesia", ATTACK_TYPE_MELEE, QUALIFICATION_SENIOR, 5, TYPE_GUARD_ARTS_FIGHTER, CLASS_GUARD, AFFIX_DPS, AFFIX_DEFENSE, null, R.drawable.type_guard_arts_fighter, R.drawable.class_guard, R.drawable.five_star_astesia));
        recruitableOperators.add(new RecruitableOperator("Swire", ATTACK_TYPE_MELEE, QUALIFICATION_SENIOR, 5, TYPE_GUARD_INSTRUCTOR, CLASS_GUARD, AFFIX_DPS, AFFIX_SUPPORT, null, R.drawable.type_guard_instructor, R.drawable.class_guard, R.drawable.five_star_swire));
        recruitableOperators.add(new RecruitableOperator("Glaucus", ATTACK_TYPE_RANGED, QUALIFICATION_SENIOR, 5, TYPE_SUPPORTER_DECEL_BINDER, CLASS_SUPPORTER, AFFIX_CROWD_CONTROL, AFFIX_SLOW, null, R.drawable.type_supporter_decelbinder, R.drawable.class_supporter, R.drawable.five_star_glaucus));
        recruitableOperators.add(new RecruitableOperator("Nightmare", ATTACK_TYPE_RANGED, QUALIFICATION_SENIOR, 5, TYPE_CASTER_CORE, CLASS_CASTER, AFFIX_DPS, AFFIX_SLOW, AFFIX_HEALING, R.drawable.type_caster_core, R.drawable.class_caster, R.drawable.five_star_nightmare));
        recruitableOperators.add(new RecruitableOperator("FEater", ATTACK_TYPE_MELEE, QUALIFICATION_SENIOR, 5, TYPE_SPECIALIST_PUSH_STROKER, CLASS_SPECIALIST, AFFIX_SHIFT, AFFIX_SLOW, null, R.drawable.type_specialist_push_stroker, R.drawable.class_specialist, R.drawable.five_star_feater));
        recruitableOperators.add(new RecruitableOperator("Manticore", ATTACK_TYPE_MELEE, QUALIFICATION_SENIOR, 5, TYPE_SPECIALIST_AMBUSHER, CLASS_SPECIALIST, AFFIX_DPS, AFFIX_SURVIVAL, null, R.drawable.type_specialist_ambusher, R.drawable.class_specialist, R.drawable.five_star_manticore));
        recruitableOperators.add(new RecruitableOperator("Istina", ATTACK_TYPE_RANGED, QUALIFICATION_SENIOR, 5, TYPE_SUPPORTER_DECEL_BINDER, CLASS_SUPPORTER, AFFIX_DPS, AFFIX_SLOW, null, R.drawable.type_supporter_decelbinder, R.drawable.class_supporter, R.drawable.five_star_istina));
        recruitableOperators.add(new RecruitableOperator("Pramanix", ATTACK_TYPE_RANGED, QUALIFICATION_SENIOR, 5, TYPE_SUPPORTER_HEXER, CLASS_SUPPORTER, AFFIX_DEBUFF, null, null, R.drawable.type_supporter_hexer, R.drawable.class_supporter, R.drawable.five_star_pramanix));
        recruitableOperators.add(new RecruitableOperator("Cliffheart", ATTACK_TYPE_MELEE, QUALIFICATION_SENIOR, 5, TYPE_SPECIALIST_HOOKMASTER, CLASS_SPECIALIST, AFFIX_SHIFT, AFFIX_DPS, null, R.drawable.type_specialist_hookmaster, R.drawable.class_specialist, R.drawable.five_star_cliffheart));
        recruitableOperators.add(new RecruitableOperator("Firewatch", ATTACK_TYPE_RANGED, QUALIFICATION_SENIOR, 5, TYPE_SNIPER_DEADEYE, CLASS_SNIPER, AFFIX_NUKER, AFFIX_DPS, null, R.drawable.type_sniper_deadeye, R.drawable.class_sniper, R.drawable.five_star_firewatch));
        recruitableOperators.add(new RecruitableOperator("Provence", ATTACK_TYPE_RANGED, QUALIFICATION_SENIOR, 5, TYPE_SNIPER_HEAVYSHOOTER, CLASS_SNIPER, AFFIX_DPS, null, null, R.drawable.type_sniper_heavyshooter, R.drawable.class_sniper, R.drawable.five_star_provence));
        recruitableOperators.add(new RecruitableOperator("Vulcan", ATTACK_TYPE_MELEE, QUALIFICATION_SENIOR, 5, TYPE_DEFENDER_JUGGERNAUT, CLASS_DEFENDER, AFFIX_DPS, AFFIX_SURVIVAL, AFFIX_DEFENSE, R.drawable.type_defender_juggernaut, R.drawable.class_defender, R.drawable.five_star_vulcan));
        recruitableOperators.add(new RecruitableOperator("Croissant", ATTACK_TYPE_MELEE, QUALIFICATION_SENIOR, 5, TYPE_DEFENDER_PROTECTOR, CLASS_DEFENDER, AFFIX_DEFENSE, AFFIX_SHIFT, null, R.drawable.type_defender_protector, R.drawable.class_defender, R.drawable.five_star_croissant));
        recruitableOperators.add(new RecruitableOperator("Liskarm", ATTACK_TYPE_MELEE, QUALIFICATION_SENIOR, 5, TYPE_DEFENDER_PROTECTOR, CLASS_DEFENDER, AFFIX_DEFENSE, AFFIX_DPS, null, R.drawable.type_defender_protector, R.drawable.class_defender, R.drawable.five_star_liskarm));
        recruitableOperators.add(new RecruitableOperator("Projekt Red", ATTACK_TYPE_MELEE, QUALIFICATION_SENIOR, 5, TYPE_SPECIALIST_EXECUTOR, CLASS_SPECIALIST, AFFIX_FAST_REDEPLOY, AFFIX_CROWD_CONTROL, null, R.drawable.type_specialist_executor, R.drawable.class_specialist, R.drawable.five_star_projekt_red));
        recruitableOperators.add(new RecruitableOperator("Nearl", ATTACK_TYPE_MELEE, QUALIFICATION_SENIOR, 5, TYPE_DEFENDER_GUARDIAN, CLASS_DEFENDER, AFFIX_HEALING, AFFIX_DEFENSE, null, R.drawable.type_defender_guardian, R.drawable.class_defender, R.drawable.five_star_nearl));
        recruitableOperators.add(new RecruitableOperator("Warfarin", ATTACK_TYPE_RANGED, QUALIFICATION_SENIOR, 5, TYPE_MEDIC_ST, CLASS_MEDIC, AFFIX_HEALING, AFFIX_SUPPORT, null, R.drawable.type_medic_st, R.drawable.class_medic, R.drawable.five_star_warfarin));
        recruitableOperators.add(new RecruitableOperator("Silence", ATTACK_TYPE_RANGED, QUALIFICATION_SENIOR, 5, TYPE_MEDIC_ST, CLASS_MEDIC, AFFIX_HEALING, null, null, R.drawable.type_medic_st, R.drawable.class_medic, R.drawable.five_star_silence));
        recruitableOperators.add(new RecruitableOperator("Mayer", ATTACK_TYPE_RANGED, QUALIFICATION_SENIOR, 5, TYPE_SUPPORTER_SUMMONER, CLASS_SUPPORTER, AFFIX_CROWD_CONTROL, AFFIX_SUMMON, null, R.drawable.type_supporter_summoner, R.drawable.class_supporter, R.drawable.five_star_mayer));
        recruitableOperators.add(new RecruitableOperator("Meteorite", ATTACK_TYPE_RANGED, QUALIFICATION_SENIOR, 5, TYPE_SNIPER_ARTILLERYMAN, CLASS_SNIPER, AFFIX_AOE, AFFIX_DEBUFF, null, R.drawable.type_sniper_artilleryman, R.drawable.class_sniper, R.drawable.five_star_meteorite));
        recruitableOperators.add(new RecruitableOperator("Platinum", ATTACK_TYPE_RANGED, QUALIFICATION_SENIOR, 5, TYPE_SNIPER_MARKSMAN, CLASS_SNIPER, AFFIX_DPS, null, null, R.drawable.type_sniper_marksman, R.drawable.class_sniper, R.drawable.five_star_platinum));
        recruitableOperators.add(new RecruitableOperator("Blue Poison", ATTACK_TYPE_RANGED, QUALIFICATION_SENIOR, 5, TYPE_SNIPER_MARKSMAN, CLASS_SNIPER, AFFIX_DPS, null, null, R.drawable.type_sniper_marksman, R.drawable.class_sniper, R.drawable.five_star_blue_poison));
        recruitableOperators.add(new RecruitableOperator("Specter", ATTACK_TYPE_MELEE, QUALIFICATION_SENIOR, 5, TYPE_GUARD_CENTURION, CLASS_GUARD, AFFIX_AOE, AFFIX_SURVIVAL, null, R.drawable.type_guard_centurion, R.drawable.class_guard, R.drawable.five_star_specter));
        recruitableOperators.add(new RecruitableOperator("Indra", ATTACK_TYPE_MELEE, QUALIFICATION_SENIOR, 5, TYPE_GUARD_FIGHTER, CLASS_GUARD, AFFIX_DPS, AFFIX_SURVIVAL, null, R.drawable.type_guard_fighter, R.drawable.class_guard, R.drawable.five_star_indra));
        recruitableOperators.add(new RecruitableOperator("Texas", ATTACK_TYPE_MELEE, QUALIFICATION_SENIOR, 5, TYPE_VANGUARD_PIONEER, CLASS_VANGUARD, AFFIX_DP_RECOVERY, AFFIX_CROWD_CONTROL, null, R.drawable.type_vanguard_pioneer, R.drawable.class_vanguard, R.drawable.five_star_texas));
        recruitableOperators.add(new RecruitableOperator("Zima", ATTACK_TYPE_MELEE, QUALIFICATION_SENIOR, 5, TYPE_VANGUARD_PIONEER, CLASS_VANGUARD, AFFIX_DP_RECOVERY, AFFIX_SUPPORT, null, R.drawable.type_vanguard_pioneer, R.drawable.class_vanguard, R.drawable.five_star_zima));
        recruitableOperators.add(new RecruitableOperator("Ptilopsis", ATTACK_TYPE_RANGED, QUALIFICATION_SENIOR, 5, TYPE_MEDIC_MULTITARGET, CLASS_MEDIC, AFFIX_HEALING, AFFIX_SUPPORT, null, R.drawable.type_medic_multitarget, R.drawable.class_medic, R.drawable.five_star_ptilopsis));
        recruitableOperators.add(new RecruitableOperator("GreyThroat", ATTACK_TYPE_RANGED, QUALIFICATION_SENIOR, 5, TYPE_SNIPER_MARKSMAN, CLASS_SNIPER, AFFIX_DPS, null, null, R.drawable.type_sniper_marksman, R.drawable.class_sniper, R.drawable.five_star_greythroat));
        recruitableOperators.add(new RecruitableOperator("Reed", ATTACK_TYPE_MELEE, QUALIFICATION_SENIOR, 5, TYPE_VANGUARD_CHARGER, CLASS_VANGUARD, AFFIX_DPS, AFFIX_DP_RECOVERY, null, R.drawable.type_vanguard_charger, R.drawable.class_vanguard, R.drawable.five_star_reed));
        recruitableOperators.add(new RecruitableOperator("Broca", ATTACK_TYPE_MELEE, QUALIFICATION_SENIOR, 5, TYPE_GUARD_CENTURION, CLASS_GUARD, AFFIX_AOE, AFFIX_SURVIVAL, null, R.drawable.type_guard_centurion, R.drawable.class_guard, R.drawable.five_star_broca));
        recruitableOperators.add(new RecruitableOperator("Hung", ATTACK_TYPE_MELEE, QUALIFICATION_SENIOR, 5, TYPE_DEFENDER_GUARDIAN, CLASS_DEFENDER, AFFIX_HEALING, AFFIX_DEFENSE, null, R.drawable.type_defender_guardian, R.drawable.class_defender, R.drawable.five_star_hung));

        // 6-star rarity
        recruitableOperators.add(new RecruitableOperator("Mostima", ATTACK_TYPE_RANGED, QUALIFICATION_TOP, 6, TYPE_CASTER_SPLASH, CLASS_CASTER, AFFIX_AOE, AFFIX_SUPPORT, AFFIX_CROWD_CONTROL, R.drawable.type_caster_splash, R.drawable.class_caster, R.drawable.six_star_mostima));
        recruitableOperators.add(new RecruitableOperator("Magallan", ATTACK_TYPE_RANGED, QUALIFICATION_TOP, 6, TYPE_SUPPORTER_SUMMONER, CLASS_SUPPORTER, AFFIX_SLOW, AFFIX_SUPPORT, AFFIX_DPS, R.drawable.type_supporter_summoner, R.drawable.class_supporter, R.drawable.six_star_magallan));
        recruitableOperators.add(new RecruitableOperator("Hellagur", ATTACK_TYPE_MELEE, QUALIFICATION_TOP, 6, TYPE_GUARD_MUSHA, CLASS_GUARD, AFFIX_DPS, AFFIX_SURVIVAL, null, R.drawable.type_guard_musha, R.drawable.class_guard, R.drawable.six_star_hellagur));
        recruitableOperators.add(new RecruitableOperator("Schwarz", ATTACK_TYPE_RANGED, QUALIFICATION_TOP, 6, TYPE_SNIPER_HEAVYSHOOTER, CLASS_SNIPER, AFFIX_DPS, null, null, R.drawable.type_sniper_heavyshooter, R.drawable.class_sniper, R.drawable.six_star_schwarz));
        recruitableOperators.add(new RecruitableOperator("Ch'en", ATTACK_TYPE_MELEE, QUALIFICATION_TOP, 6, TYPE_GUARD_SWORDMASTER, CLASS_GUARD, AFFIX_DPS, AFFIX_NUKER, null, R.drawable.type_guard_swordmaster, R.drawable.class_guard, R.drawable.six_star_chen));
        recruitableOperators.add(new RecruitableOperator("Skadi", ATTACK_TYPE_MELEE, QUALIFICATION_TOP, 6, TYPE_GUARD_DREADNOUGHT, CLASS_GUARD, AFFIX_DPS, AFFIX_SURVIVAL, null, R.drawable.type_guard_dreadnought, R.drawable.class_guard, R.drawable.six_star_skadi));
        recruitableOperators.add(new RecruitableOperator("SilverAsh", ATTACK_TYPE_MELEE, QUALIFICATION_TOP, 6, TYPE_GUARD_LORD, CLASS_GUARD, AFFIX_DPS, AFFIX_SUPPORT, null, R.drawable.type_guard_lord, R.drawable.class_guard, R.drawable.six_star_silverash));
        recruitableOperators.add(new RecruitableOperator("Saria", ATTACK_TYPE_MELEE, QUALIFICATION_TOP, 6, TYPE_DEFENDER_GUARDIAN, CLASS_DEFENDER, AFFIX_HEALING, AFFIX_DEFENSE, AFFIX_SUPPORT, R.drawable.type_defender_guardian, R.drawable.class_defender, R.drawable.six_star_saria));
        recruitableOperators.add(new RecruitableOperator("Hoshiguma", ATTACK_TYPE_MELEE, QUALIFICATION_TOP, 6, TYPE_DEFENDER_PROTECTOR, CLASS_DEFENDER, AFFIX_DPS, AFFIX_DEFENSE, null, R.drawable.type_defender_protector, R.drawable.class_defender, R.drawable.six_star_hoshiguma));
        recruitableOperators.add(new RecruitableOperator("Nightingale", ATTACK_TYPE_RANGED, QUALIFICATION_TOP, 6, TYPE_MEDIC_MULTITARGET, CLASS_MEDIC, AFFIX_HEALING, AFFIX_SUPPORT, null, R.drawable.type_medic_multitarget, R.drawable.class_medic, R.drawable.six_star_nightingale));
        recruitableOperators.add(new RecruitableOperator("Shining", ATTACK_TYPE_RANGED, QUALIFICATION_TOP, 6, TYPE_MEDIC_ST, CLASS_MEDIC, AFFIX_HEALING, AFFIX_SUPPORT, null, R.drawable.type_medic_st, R.drawable.class_medic, R.drawable.six_star_shining));
        recruitableOperators.add(new RecruitableOperator("Ifrit", ATTACK_TYPE_RANGED, QUALIFICATION_TOP, 6, TYPE_CASTER_BLAST, CLASS_CASTER, AFFIX_AOE, AFFIX_DEBUFF, null, R.drawable.type_caster_blast, R.drawable.class_caster, R.drawable.six_star_ifrit));
        recruitableOperators.add(new RecruitableOperator("Siege", ATTACK_TYPE_MELEE, QUALIFICATION_TOP, 6, TYPE_VANGUARD_PIONEER, CLASS_VANGUARD, AFFIX_DPS, AFFIX_DP_RECOVERY, null, R.drawable.type_vanguard_pioneer, R.drawable.class_vanguard, R.drawable.six_star_siege));
        recruitableOperators.add(new RecruitableOperator("Exusiai", ATTACK_TYPE_RANGED, QUALIFICATION_TOP, 6, TYPE_SNIPER_MARKSMAN, CLASS_SNIPER, AFFIX_DPS, null, null, R.drawable.type_sniper_marksman, R.drawable.class_sniper, R.drawable.six_star_exusiai));
        recruitableOperators.add(new RecruitableOperator("Blaze", ATTACK_TYPE_MELEE, QUALIFICATION_TOP, 6, TYPE_GUARD_CENTURION, CLASS_GUARD, AFFIX_DPS, AFFIX_SURVIVAL, null, R.drawable.type_guard_centurion, R.drawable.class_guard, R.drawable.six_star_blaze));
        recruitableOperators.add(new RecruitableOperator("Aak", ATTACK_TYPE_RANGED, QUALIFICATION_TOP, 6, TYPE_SPECIALIST_GEEK, CLASS_SPECIALIST, AFFIX_DPS, AFFIX_SUPPORT, null, R.drawable.type_specialist_geek, R.drawable.class_specialist, R.drawable.six_star_aak));
    }
}


