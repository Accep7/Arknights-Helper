package com.accep7.arknightshelper;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
    //protected final static String TYPE_SPECIALIST_GEEK = "Geek";
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
    //protected final static String TYPE_DEFENDER_ARTS = "Arts";
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

    protected static class RecruitableOperator {
        final String operatorName;
        final String attackType;
        final String qualification;
        final int rarity;
        final String archetype;
        final String inGameClass;
        final String affix1;
        final String affix2;
        final String affix3;
        int archetypeIconResourceID;
        int classIconResourceID;

        //Used for showing expandable menu with operator details in results list
        boolean expandedDetails;

        public boolean isExpandedDetails() {
            return expandedDetails;
        }

        public void setExpandedDetails(boolean expandedDetails) {
            this.expandedDetails = expandedDetails;
        }

        RecruitableOperator(String operatorName, String attackType, String qualification, int rarity,
                            String archetype, String inGameClass, String affix1, String affix2,
                            String affix3, int archetypeIconResourceID, int classIconResourceID) {
            this.operatorName = operatorName;
            this.attackType = attackType;
            this.qualification = qualification;
            this.rarity = rarity;
            this.archetype = archetype;
            this.inGameClass = inGameClass;
            this.affix1 = affix1;
            this.affix2 = affix2;
            this.affix3 = affix3;
            this.archetypeIconResourceID = archetypeIconResourceID;
            this.classIconResourceID = classIconResourceID;
            this.expandedDetails = false;
        }

        public List<String> getTags() {
            List<String> result = new ArrayList<>();
            result.add(attackType);
            result.add(qualification);
            result.add("" + rarity);
            result.add(inGameClass);
            result.add(affix1);
            result.add(affix2);
            result.add(affix3);
            return result;
        }

        @Override
        @NonNull
        public String toString() {
            return "RecruitableOperator{" +
                    "name='" + operatorName + '\'' +
                    ", attackType='" + attackType + '\'' +
                    ", qualification='" + qualification + '\'' +
                    ", rarity=" + rarity +
                    ", inGameClass='" + archetype + '\'' +
                    ", inGameClass='" + inGameClass + '\'' +
                    ", affix1='" + affix1 + '\'' +
                    ", affix2='" + affix2 + '\'' +
                    ", affix3='" + affix3 + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            RecruitableOperator that = (RecruitableOperator) o;
            return rarity == that.rarity && Objects.equals(operatorName, that.operatorName) &&
                    Objects.equals(attackType, that.attackType) &&
                    Objects.equals(qualification, that.qualification) &&
                    Objects.equals(inGameClass, that.inGameClass) &&
                    Objects.equals(affix1, that.affix1) && Objects.equals(affix2, that.affix2) &&
                    Objects.equals(affix3, that.affix3);
        }

        @Override
        public int hashCode() {
            return Objects.hash(operatorName, attackType, qualification, rarity, inGameClass,
                    affix1, affix2, affix3);
        }
    }

    static List<String> operatorTags = new ArrayList<>();

    static {
        operatorTags.add(QUALIFICATION_STARTER);
        operatorTags.add(QUALIFICATION_SENIOR);
        operatorTags.add(QUALIFICATION_TOP);

        operatorTags.add(ATTACK_TYPE_MELEE);
        operatorTags.add(ATTACK_TYPE_RANGED);

        operatorTags.add(CLASS_GUARD);
        operatorTags.add(CLASS_SPECIALIST);
        operatorTags.add(CLASS_SNIPER);
        operatorTags.add(CLASS_CASTER);
        operatorTags.add(CLASS_DEFENDER);
        operatorTags.add(CLASS_MEDIC);
        operatorTags.add(CLASS_SUPPORTER);
        operatorTags.add(CLASS_VANGUARD);

        operatorTags.add(AFFIX_HEALING);
        operatorTags.add(AFFIX_DEFENSE);
        operatorTags.add(AFFIX_SLOW);
        operatorTags.add(AFFIX_DP_RECOVERY);
        operatorTags.add(AFFIX_AOE);
        operatorTags.add(AFFIX_DPS);
        operatorTags.add(AFFIX_SURVIVAL);
        operatorTags.add(AFFIX_SHIFT);
        operatorTags.add(AFFIX_SUPPORT);
        operatorTags.add(AFFIX_DEBUFF);
        operatorTags.add(AFFIX_FAST_REDEPLOY);
        operatorTags.add(AFFIX_ROBOT);
        operatorTags.add(AFFIX_SUMMON);
        operatorTags.add(AFFIX_CROWD_CONTROL);
        operatorTags.add(AFFIX_NUKER);
    }

    /* The RecruitmentPool ArrayList, that contains all of the current global server operators in recruitment pool.
     * When in-game recruitment pool updates, simply add a new RecruitableOperator to this ArrayList and assign its in-game attributes */
    static List<RecruitableOperator> recruitableOperators = new ArrayList<>();

    static {
        //1-star rarity
        recruitableOperators.add(new RecruitableOperator("Lancet-2", ATTACK_TYPE_RANGED, null, 1, TYPE_MEDIC_ST, CLASS_MEDIC, AFFIX_HEALING, AFFIX_ROBOT, null, R.mipmap.type_medic_st, R.mipmap.class_medic));
        recruitableOperators.add(new RecruitableOperator("Castle-3", ATTACK_TYPE_MELEE, null, 1, TYPE_GUARD_DREADNOUGHT, CLASS_GUARD, AFFIX_SUPPORT, AFFIX_ROBOT, null, R.mipmap.type_guard_dreadnought, R.mipmap.class_guard));
        recruitableOperators.add(new RecruitableOperator("THRM-EX", ATTACK_TYPE_MELEE, null, 1, TYPE_SPECIALIST_EXECUTOR, CLASS_SPECIALIST, AFFIX_NUKER, AFFIX_ROBOT, null, R.mipmap.type_specialist_executor, R.mipmap.class_specialist));

        //2-star rarity
        recruitableOperators.add(new RecruitableOperator("12F", ATTACK_TYPE_RANGED, QUALIFICATION_STARTER, 2, TYPE_CASTER_SPLASH, CLASS_CASTER, null, null, null, R.mipmap.type_caster_splash, R.mipmap.class_caster));
        recruitableOperators.add(new RecruitableOperator("Durin", ATTACK_TYPE_RANGED, QUALIFICATION_STARTER, 2, TYPE_CASTER_CORE, CLASS_CASTER, null, null, null, R.mipmap.type_caster_core, R.mipmap.class_caster));
        recruitableOperators.add(new RecruitableOperator("Rangers", ATTACK_TYPE_RANGED, QUALIFICATION_STARTER, 2, TYPE_SNIPER_MARKSMAN, CLASS_SNIPER, null, null, null, R.mipmap.type_sniper_marksman, R.mipmap.class_sniper));
        recruitableOperators.add(new RecruitableOperator("Noir Corne", ATTACK_TYPE_MELEE, QUALIFICATION_STARTER, 2, TYPE_DEFENDER_PROTECTOR, CLASS_DEFENDER, null, null, null, R.mipmap.type_defender_protector, R.mipmap.class_defender));
        recruitableOperators.add(new RecruitableOperator("Yato", ATTACK_TYPE_MELEE, QUALIFICATION_STARTER, 2, TYPE_VANGUARD_PIONEER, CLASS_VANGUARD, null, null, null, R.mipmap.type_vanguard_pioneer, R.mipmap.class_vanguard));

        //3-star rarity
        recruitableOperators.add(new RecruitableOperator("Popukar", ATTACK_TYPE_MELEE, null, 3, TYPE_GUARD_CENTURION, CLASS_GUARD, AFFIX_AOE, AFFIX_SURVIVAL, null, R.mipmap.type_guard_centurion, R.mipmap.class_guard));
        recruitableOperators.add(new RecruitableOperator("Spot", ATTACK_TYPE_MELEE, null, 3, TYPE_DEFENDER_GUARDIAN, CLASS_DEFENDER, AFFIX_HEALING, AFFIX_DEFENSE, null, R.mipmap.type_defender_guardian, R.mipmap.class_defender));
        recruitableOperators.add(new RecruitableOperator("Midnight", ATTACK_TYPE_MELEE, null, 3, TYPE_GUARD_LORD, CLASS_GUARD, AFFIX_DPS, null, null, R.mipmap.type_guard_lord, R.mipmap.class_guard));
        recruitableOperators.add(new RecruitableOperator("Catapult", ATTACK_TYPE_RANGED, null, 3, TYPE_SNIPER_ARTILLERYMAN, CLASS_SNIPER, AFFIX_AOE, null, null, R.mipmap.type_sniper_artilleryman, R.mipmap.class_sniper));
        recruitableOperators.add(new RecruitableOperator("Orchid", ATTACK_TYPE_RANGED, null, 3, TYPE_SUPPORTER_DECEL_BINDER, CLASS_SUPPORTER, AFFIX_SLOW, null, null, R.mipmap.type_supporter_decelbinder, R.mipmap.class_supporter));
        recruitableOperators.add(new RecruitableOperator("Steward", ATTACK_TYPE_RANGED, null, 3, TYPE_CASTER_CORE, CLASS_CASTER, AFFIX_DPS, null, null, R.mipmap.type_caster_core, R.mipmap.class_caster));
        recruitableOperators.add(new RecruitableOperator("Ansel", ATTACK_TYPE_RANGED, null, 3, TYPE_MEDIC_ST, CLASS_MEDIC, AFFIX_HEALING, null, null, R.mipmap.type_medic_st, R.mipmap.class_medic));
        recruitableOperators.add(new RecruitableOperator("Hibiscus", ATTACK_TYPE_RANGED, null, 3, TYPE_MEDIC_ST, CLASS_MEDIC, AFFIX_HEALING, null, null, R.mipmap.type_medic_st, R.mipmap.class_medic));
        recruitableOperators.add(new RecruitableOperator("Lava", ATTACK_TYPE_RANGED, null, 3, TYPE_CASTER_SPLASH, CLASS_CASTER, AFFIX_AOE, null, null, R.mipmap.type_caster_splash, R.mipmap.class_caster));
        recruitableOperators.add(new RecruitableOperator("Adnachiel", ATTACK_TYPE_RANGED, null, 3, TYPE_SNIPER_MARKSMAN, CLASS_SNIPER, AFFIX_DPS, null, null, R.mipmap.type_sniper_marksman, R.mipmap.class_sniper));
        recruitableOperators.add(new RecruitableOperator("Kroos", ATTACK_TYPE_RANGED, null, 3, TYPE_SNIPER_MARKSMAN, CLASS_SNIPER, AFFIX_DPS, null, null, R.mipmap.type_sniper_marksman, R.mipmap.class_sniper));
        recruitableOperators.add(new RecruitableOperator("Beagle", ATTACK_TYPE_MELEE, null, 3, TYPE_DEFENDER_PROTECTOR, CLASS_DEFENDER, AFFIX_DEFENSE, null, null, R.mipmap.type_defender_protector, R.mipmap.class_defender));
        recruitableOperators.add(new RecruitableOperator("Melantha", ATTACK_TYPE_MELEE, null, 3, TYPE_GUARD_DREADNOUGHT, CLASS_GUARD, AFFIX_DPS, AFFIX_SURVIVAL, null, R.mipmap.type_guard_dreadnought, R.mipmap.class_guard));
        recruitableOperators.add(new RecruitableOperator("Plume", ATTACK_TYPE_MELEE, null, 3, TYPE_VANGUARD_CHARGER, CLASS_VANGUARD, AFFIX_DPS, AFFIX_DP_RECOVERY, null, R.mipmap.type_vanguard_charger, R.mipmap.class_vanguard));
        recruitableOperators.add(new RecruitableOperator("Vanilla", ATTACK_TYPE_MELEE, null, 3, TYPE_VANGUARD_PIONEER, CLASS_VANGUARD, AFFIX_DP_RECOVERY, null, null, R.mipmap.type_vanguard_pioneer, R.mipmap.class_vanguard));
        recruitableOperators.add(new RecruitableOperator("Fang", ATTACK_TYPE_MELEE, null, 3, TYPE_VANGUARD_PIONEER, CLASS_VANGUARD, AFFIX_DP_RECOVERY, null, null, R.mipmap.type_vanguard_pioneer, R.mipmap.class_vanguard));

        //4-star rarity
        recruitableOperators.add(new RecruitableOperator("May", ATTACK_TYPE_RANGED, null, 4, TYPE_SNIPER_MARKSMAN, CLASS_SNIPER, AFFIX_DPS, AFFIX_SLOW, null, R.mipmap.type_sniper_marksman, R.mipmap.class_sniper));
        recruitableOperators.add(new RecruitableOperator("Vermeil", ATTACK_TYPE_RANGED, null, 4, TYPE_SNIPER_MARKSMAN, CLASS_SNIPER, AFFIX_DPS, null, null, R.mipmap.type_sniper_marksman, R.mipmap.class_sniper));
        recruitableOperators.add(new RecruitableOperator("Myrtle", ATTACK_TYPE_MELEE, null, 4, TYPE_VANGUARD_STANDARD_BEARER, CLASS_VANGUARD, AFFIX_DP_RECOVERY, AFFIX_HEALING, null, R.mipmap.type_vanguard_standardbearer, R.mipmap.class_vanguard));
        recruitableOperators.add(new RecruitableOperator("Greyy", ATTACK_TYPE_RANGED, null, 4, TYPE_CASTER_SPLASH, CLASS_CASTER, AFFIX_AOE, AFFIX_SLOW, null, R.mipmap.type_caster_splash, R.mipmap.class_caster));
        recruitableOperators.add(new RecruitableOperator("Sussuro", ATTACK_TYPE_RANGED, null, 4, TYPE_MEDIC_ST, CLASS_MEDIC, AFFIX_HEALING, null, null, R.mipmap.type_medic_st, R.mipmap.class_medic));
        recruitableOperators.add(new RecruitableOperator("Beehunter", ATTACK_TYPE_MELEE, null, 4, TYPE_GUARD_FIGHTER, CLASS_GUARD, AFFIX_DPS, null, null, R.mipmap.type_guard_fighter, R.mipmap.class_guard));
        recruitableOperators.add(new RecruitableOperator("Shaw", ATTACK_TYPE_MELEE, null, 4, TYPE_SPECIALIST_PUSH_STROKER, CLASS_SPECIALIST, AFFIX_SHIFT, null, null, R.mipmap.type_specialist_push_stroker, R.mipmap.class_specialist));
        recruitableOperators.add(new RecruitableOperator("Earthspirit", ATTACK_TYPE_RANGED, null, 4, TYPE_SUPPORTER_DECEL_BINDER, CLASS_SUPPORTER, AFFIX_SLOW, null, null, R.mipmap.type_supporter_decelbinder, R.mipmap.class_supporter));
        recruitableOperators.add(new RecruitableOperator("Gummy", ATTACK_TYPE_MELEE, null, 4, TYPE_DEFENDER_GUARDIAN, CLASS_DEFENDER, AFFIX_DEFENSE, AFFIX_HEALING, null, R.mipmap.type_defender_guardian, R.mipmap.class_defender));
        recruitableOperators.add(new RecruitableOperator("Cuora", ATTACK_TYPE_MELEE, null, 4, TYPE_DEFENDER_PROTECTOR, CLASS_DEFENDER, AFFIX_DEFENSE, null, null, R.mipmap.type_defender_protector, R.mipmap.class_defender));
        recruitableOperators.add(new RecruitableOperator("Matterhorn", ATTACK_TYPE_MELEE, null, 4, TYPE_DEFENDER_PROTECTOR, CLASS_DEFENDER, AFFIX_DEFENSE, null, null, R.mipmap.type_defender_protector, R.mipmap.class_defender));
        recruitableOperators.add(new RecruitableOperator("Perfumer", ATTACK_TYPE_RANGED, null, 4, TYPE_MEDIC_MULTITARGET, CLASS_MEDIC, AFFIX_HEALING, null, null, R.mipmap.type_medic_multitarget, R.mipmap.class_medic));
        recruitableOperators.add(new RecruitableOperator("Myrrh", ATTACK_TYPE_RANGED, null, 4, TYPE_MEDIC_ST, CLASS_MEDIC, AFFIX_HEALING, null, null, R.mipmap.type_medic_st, R.mipmap.class_medic));
        recruitableOperators.add(new RecruitableOperator("Rope", ATTACK_TYPE_MELEE, null, 4, TYPE_SPECIALIST_HOOKMASTER, CLASS_SPECIALIST, AFFIX_SHIFT, null, null, R.mipmap.type_specialist_hookmaster, R.mipmap.class_specialist));
        recruitableOperators.add(new RecruitableOperator("Gravel", ATTACK_TYPE_MELEE, null, 4, TYPE_SPECIALIST_EXECUTOR, CLASS_SPECIALIST, AFFIX_DEFENSE, AFFIX_FAST_REDEPLOY, null, R.mipmap.type_specialist_executor, R.mipmap.class_specialist));
        recruitableOperators.add(new RecruitableOperator("Mousse", ATTACK_TYPE_MELEE, null, 4, TYPE_GUARD_ARTS_FIGHTER, CLASS_GUARD, AFFIX_DPS, null, null, R.mipmap.type_guard_arts_fighter, R.mipmap.class_guard));
        recruitableOperators.add(new RecruitableOperator("Estelle", ATTACK_TYPE_MELEE, null, 4, TYPE_GUARD_CENTURION, CLASS_GUARD, AFFIX_AOE, AFFIX_SURVIVAL, null, R.mipmap.type_guard_centurion, R.mipmap.class_guard));
        recruitableOperators.add(new RecruitableOperator("Frostleaf", ATTACK_TYPE_MELEE, null, 4, TYPE_GUARD_LORD, CLASS_GUARD, AFFIX_DPS, AFFIX_SLOW, null, R.mipmap.type_guard_lord, R.mipmap.class_guard));
        recruitableOperators.add(new RecruitableOperator("Matoimaru", ATTACK_TYPE_MELEE, null, 4, TYPE_GUARD_DREADNOUGHT, CLASS_GUARD, AFFIX_DPS, AFFIX_SURVIVAL, null, R.mipmap.type_guard_dreadnought, R.mipmap.class_guard));
        recruitableOperators.add(new RecruitableOperator("Dobermann", ATTACK_TYPE_MELEE, null, 4, TYPE_GUARD_INSTRUCTOR, CLASS_GUARD, AFFIX_DPS, AFFIX_SUPPORT, null, R.mipmap.type_guard_instructor, R.mipmap.class_guard));
        recruitableOperators.add(new RecruitableOperator("Vigna", ATTACK_TYPE_MELEE, null, 4, TYPE_VANGUARD_CHARGER, CLASS_VANGUARD, AFFIX_DPS, AFFIX_DP_RECOVERY, null, R.mipmap.type_vanguard_charger, R.mipmap.class_vanguard));
        recruitableOperators.add(new RecruitableOperator("Scavenger", ATTACK_TYPE_MELEE, null, 4, TYPE_VANGUARD_PIONEER, CLASS_VANGUARD, AFFIX_DPS, AFFIX_DP_RECOVERY, null, R.mipmap.type_vanguard_pioneer, R.mipmap.class_vanguard));
        recruitableOperators.add(new RecruitableOperator("Shirayuki", ATTACK_TYPE_RANGED, null, 4, TYPE_SNIPER_ARTILLERYMAN, CLASS_SNIPER, AFFIX_AOE, AFFIX_SLOW, null, R.mipmap.type_sniper_artilleryman, R.mipmap.class_sniper));
        recruitableOperators.add(new RecruitableOperator("Meteor", ATTACK_TYPE_RANGED, null, 4, TYPE_SNIPER_MARKSMAN, CLASS_SNIPER, AFFIX_DPS, AFFIX_DEBUFF, null, R.mipmap.type_sniper_marksman, R.mipmap.class_sniper));
        recruitableOperators.add(new RecruitableOperator("Jessica", ATTACK_TYPE_RANGED, null, 4, TYPE_SNIPER_MARKSMAN, CLASS_SNIPER, AFFIX_DPS, AFFIX_SURVIVAL, null, R.mipmap.type_sniper_marksman, R.mipmap.class_sniper));
        recruitableOperators.add(new RecruitableOperator("Gitano", ATTACK_TYPE_RANGED, null, 4, TYPE_CASTER_SPLASH, CLASS_CASTER, AFFIX_AOE, null, null, R.mipmap.type_caster_splash, R.mipmap.class_caster));
        recruitableOperators.add(new RecruitableOperator("Haze", ATTACK_TYPE_RANGED, null, 4, TYPE_CASTER_CORE, CLASS_CASTER, AFFIX_DPS, AFFIX_DEBUFF, null, R.mipmap.type_caster_core, R.mipmap.class_caster));
        recruitableOperators.add(new RecruitableOperator("Ambriel", ATTACK_TYPE_RANGED, null, 4, TYPE_SNIPER_DEADEYE, CLASS_SNIPER, AFFIX_DPS, AFFIX_SLOW, null, R.mipmap.type_sniper_deadeye, R.mipmap.class_sniper));

        //5-star rarity
        recruitableOperators.add(new RecruitableOperator("Waai Fu", ATTACK_TYPE_MELEE, QUALIFICATION_SENIOR, 5, TYPE_SPECIALIST_EXECUTOR, CLASS_SPECIALIST, AFFIX_FAST_REDEPLOY, AFFIX_DEBUFF, null, R.mipmap.type_specialist_executor, R.mipmap.class_specialist));
        recruitableOperators.add(new RecruitableOperator("Executor", ATTACK_TYPE_RANGED, QUALIFICATION_SENIOR, 5, TYPE_SNIPER_SPREADSHOOTER, CLASS_SNIPER, AFFIX_AOE, null, null, R.mipmap.type_sniper_spreadshooter, R.mipmap.class_sniper));
        recruitableOperators.add(new RecruitableOperator("Astesia", ATTACK_TYPE_MELEE, QUALIFICATION_SENIOR, 5, TYPE_GUARD_ARTS_FIGHTER, CLASS_GUARD, AFFIX_DPS, AFFIX_DEFENSE, null, R.mipmap.type_guard_arts_fighter, R.mipmap.class_guard));
        recruitableOperators.add(new RecruitableOperator("Swire", ATTACK_TYPE_MELEE, QUALIFICATION_SENIOR, 5, TYPE_GUARD_INSTRUCTOR, CLASS_GUARD, AFFIX_DPS, AFFIX_SUPPORT, null, R.mipmap.type_guard_instructor, R.mipmap.class_guard));
        recruitableOperators.add(new RecruitableOperator("Glaucus", ATTACK_TYPE_RANGED, QUALIFICATION_SENIOR, 5, TYPE_SUPPORTER_DECEL_BINDER, CLASS_SUPPORTER, AFFIX_CROWD_CONTROL, AFFIX_SLOW, null, R.mipmap.type_supporter_decelbinder, R.mipmap.class_supporter));
        recruitableOperators.add(new RecruitableOperator("Nightmare", ATTACK_TYPE_RANGED, QUALIFICATION_SENIOR, 5, TYPE_CASTER_CORE, CLASS_CASTER, AFFIX_DPS, AFFIX_SLOW, AFFIX_HEALING, R.mipmap.type_caster_core, R.mipmap.class_caster));
        recruitableOperators.add(new RecruitableOperator("FEater", ATTACK_TYPE_MELEE, QUALIFICATION_SENIOR, 5, TYPE_SPECIALIST_PUSH_STROKER, CLASS_SPECIALIST, AFFIX_SHIFT, AFFIX_SLOW, null, R.mipmap.type_specialist_push_stroker, R.mipmap.class_specialist));
        recruitableOperators.add(new RecruitableOperator("Manticore", ATTACK_TYPE_MELEE, QUALIFICATION_SENIOR, 5, TYPE_SPECIALIST_AMBUSHER, CLASS_SPECIALIST, AFFIX_DPS, AFFIX_SURVIVAL, null, R.mipmap.type_specialist_ambusher, R.mipmap.class_specialist));
        recruitableOperators.add(new RecruitableOperator("Istina", ATTACK_TYPE_RANGED, QUALIFICATION_SENIOR, 5, TYPE_SUPPORTER_DECEL_BINDER, CLASS_SUPPORTER, AFFIX_DPS, AFFIX_SLOW, null, R.mipmap.type_supporter_decelbinder, R.mipmap.class_supporter));
        recruitableOperators.add(new RecruitableOperator("Pramanix", ATTACK_TYPE_RANGED, QUALIFICATION_SENIOR, 5, TYPE_SUPPORTER_HEXER, CLASS_SUPPORTER, AFFIX_DEBUFF, null, null, R.mipmap.type_supporter_hexer, R.mipmap.class_supporter));
        recruitableOperators.add(new RecruitableOperator("Cliffheart", ATTACK_TYPE_MELEE, QUALIFICATION_SENIOR, 5, TYPE_SPECIALIST_HOOKMASTER, CLASS_SPECIALIST, AFFIX_SHIFT, AFFIX_DPS, null, R.mipmap.type_specialist_hookmaster, R.mipmap.class_specialist));
        recruitableOperators.add(new RecruitableOperator("Firewatch", ATTACK_TYPE_RANGED, QUALIFICATION_SENIOR, 5, TYPE_SNIPER_DEADEYE, CLASS_SNIPER, AFFIX_NUKER, AFFIX_DPS, null, R.mipmap.type_sniper_deadeye, R.mipmap.class_sniper));
        recruitableOperators.add(new RecruitableOperator("Provence", ATTACK_TYPE_RANGED, QUALIFICATION_SENIOR, 5, TYPE_SNIPER_HEAVYSHOOTER, CLASS_SNIPER, AFFIX_DPS, null, null, R.mipmap.type_sniper_heavyshooter, R.mipmap.class_sniper));
        recruitableOperators.add(new RecruitableOperator("Vulcan", ATTACK_TYPE_MELEE, QUALIFICATION_SENIOR, 5, TYPE_DEFENDER_JUGGERNAUT, CLASS_DEFENDER, AFFIX_DPS, AFFIX_SURVIVAL, AFFIX_DEFENSE, R.mipmap.type_defender_juggernaut, R.mipmap.class_defender));
        recruitableOperators.add(new RecruitableOperator("Croissant", ATTACK_TYPE_MELEE, QUALIFICATION_SENIOR, 5, TYPE_DEFENDER_PROTECTOR, CLASS_DEFENDER, AFFIX_DEFENSE, AFFIX_SHIFT, null, R.mipmap.type_defender_protector, R.mipmap.class_defender));
        recruitableOperators.add(new RecruitableOperator("Liskarm", ATTACK_TYPE_MELEE, QUALIFICATION_SENIOR, 5, TYPE_DEFENDER_PROTECTOR, CLASS_DEFENDER, AFFIX_DEFENSE, AFFIX_DPS, null, R.mipmap.type_defender_protector, R.mipmap.class_defender));
        recruitableOperators.add(new RecruitableOperator("Projekt Red", ATTACK_TYPE_MELEE, QUALIFICATION_SENIOR, 5, TYPE_SPECIALIST_EXECUTOR, CLASS_SPECIALIST, AFFIX_FAST_REDEPLOY, AFFIX_CROWD_CONTROL, null, R.mipmap.type_specialist_executor, R.mipmap.class_specialist));
        recruitableOperators.add(new RecruitableOperator("Nearl", ATTACK_TYPE_MELEE, QUALIFICATION_SENIOR, 5, TYPE_DEFENDER_GUARDIAN, CLASS_DEFENDER, AFFIX_HEALING, AFFIX_DEFENSE, null, R.mipmap.type_defender_guardian, R.mipmap.class_defender));
        recruitableOperators.add(new RecruitableOperator("Warfarin", ATTACK_TYPE_RANGED, QUALIFICATION_SENIOR, 5, TYPE_MEDIC_ST, CLASS_MEDIC, AFFIX_HEALING, AFFIX_SUPPORT, null, R.mipmap.type_medic_st, R.mipmap.class_medic));
        recruitableOperators.add(new RecruitableOperator("Silence", ATTACK_TYPE_RANGED, QUALIFICATION_SENIOR, 5, TYPE_MEDIC_ST, CLASS_MEDIC, AFFIX_HEALING, null, null, R.mipmap.type_medic_st, R.mipmap.class_medic));
        recruitableOperators.add(new RecruitableOperator("Mayer", ATTACK_TYPE_RANGED, QUALIFICATION_SENIOR, 5, TYPE_SUPPORTER_SUMMONER, CLASS_SUPPORTER, AFFIX_CROWD_CONTROL, AFFIX_SUMMON, null, R.mipmap.type_supporter_summoner, R.mipmap.class_supporter));
        recruitableOperators.add(new RecruitableOperator("Meteorite", ATTACK_TYPE_RANGED, QUALIFICATION_SENIOR, 5, TYPE_SNIPER_ARTILLERYMAN, CLASS_SNIPER, AFFIX_AOE, AFFIX_DEBUFF, null, R.mipmap.type_sniper_artilleryman, R.mipmap.class_sniper));
        recruitableOperators.add(new RecruitableOperator("Platinum", ATTACK_TYPE_RANGED, QUALIFICATION_SENIOR, 5, TYPE_SNIPER_MARKSMAN, CLASS_SNIPER, AFFIX_DPS, null, null, R.mipmap.type_sniper_marksman, R.mipmap.class_sniper));
        recruitableOperators.add(new RecruitableOperator("Blue Poison", ATTACK_TYPE_RANGED, QUALIFICATION_SENIOR, 5, TYPE_SNIPER_MARKSMAN, CLASS_SNIPER, AFFIX_DPS, null, null, R.mipmap.type_sniper_marksman, R.mipmap.class_sniper));
        recruitableOperators.add(new RecruitableOperator("Specter", ATTACK_TYPE_MELEE, QUALIFICATION_SENIOR, 5, TYPE_GUARD_CENTURION, CLASS_GUARD, AFFIX_AOE, AFFIX_SURVIVAL, null, R.mipmap.type_guard_centurion, R.mipmap.class_guard));
        recruitableOperators.add(new RecruitableOperator("Indra", ATTACK_TYPE_MELEE, QUALIFICATION_SENIOR, 5, TYPE_GUARD_FIGHTER, CLASS_GUARD, AFFIX_DPS, AFFIX_SURVIVAL, null, R.mipmap.type_guard_fighter, R.mipmap.class_guard));
        recruitableOperators.add(new RecruitableOperator("Texas", ATTACK_TYPE_MELEE, QUALIFICATION_SENIOR, 5, TYPE_VANGUARD_PIONEER, CLASS_VANGUARD, AFFIX_DP_RECOVERY, AFFIX_CROWD_CONTROL, null, R.mipmap.type_vanguard_pioneer, R.mipmap.class_vanguard));
        recruitableOperators.add(new RecruitableOperator("Zima", ATTACK_TYPE_MELEE, QUALIFICATION_SENIOR, 5, TYPE_VANGUARD_PIONEER, CLASS_VANGUARD, AFFIX_DP_RECOVERY, AFFIX_SUPPORT, null, R.mipmap.type_vanguard_pioneer, R.mipmap.class_vanguard));
        recruitableOperators.add(new RecruitableOperator("Ptilopsis", ATTACK_TYPE_RANGED, QUALIFICATION_SENIOR, 5, TYPE_MEDIC_MULTITARGET, CLASS_MEDIC, AFFIX_HEALING, AFFIX_SUPPORT, null, R.mipmap.type_medic_multitarget, R.mipmap.class_medic));
        recruitableOperators.add(new RecruitableOperator("GreyThroat", ATTACK_TYPE_RANGED, QUALIFICATION_SENIOR, 5, TYPE_SNIPER_MARKSMAN, CLASS_SNIPER, AFFIX_DPS, null, null, R.mipmap.type_sniper_marksman, R.mipmap.class_sniper));
        recruitableOperators.add(new RecruitableOperator("Reed", ATTACK_TYPE_MELEE, QUALIFICATION_SENIOR, 5, TYPE_VANGUARD_CHARGER, CLASS_VANGUARD, AFFIX_DPS, AFFIX_DP_RECOVERY, null, R.mipmap.type_vanguard_charger, R.mipmap.class_vanguard));
        recruitableOperators.add(new RecruitableOperator("Broca", ATTACK_TYPE_MELEE, QUALIFICATION_SENIOR, 5, TYPE_GUARD_CENTURION, CLASS_GUARD, AFFIX_AOE, AFFIX_SURVIVAL, null, R.mipmap.type_guard_centurion, R.mipmap.class_guard));


        //6-star rarity
        recruitableOperators.add(new RecruitableOperator("Mostima", ATTACK_TYPE_RANGED, QUALIFICATION_TOP, 6, TYPE_CASTER_SPLASH, CLASS_CASTER, AFFIX_AOE, AFFIX_SUPPORT, AFFIX_CROWD_CONTROL, R.mipmap.type_caster_splash, R.mipmap.class_caster));
        recruitableOperators.add(new RecruitableOperator("Magallan", ATTACK_TYPE_RANGED, QUALIFICATION_TOP, 6, TYPE_SUPPORTER_SUMMONER, CLASS_SUPPORTER, AFFIX_SLOW, AFFIX_SUPPORT, AFFIX_DPS, R.mipmap.type_supporter_summoner, R.mipmap.class_supporter));
        recruitableOperators.add(new RecruitableOperator("Hellagur", ATTACK_TYPE_MELEE, QUALIFICATION_TOP, 6, TYPE_GUARD_MUSHA, CLASS_GUARD, AFFIX_DPS, AFFIX_SURVIVAL, null, R.mipmap.type_guard_musha, R.mipmap.class_guard));
        recruitableOperators.add(new RecruitableOperator("Schwarz", ATTACK_TYPE_RANGED, QUALIFICATION_TOP, 6, TYPE_SNIPER_HEAVYSHOOTER, CLASS_SNIPER, AFFIX_DPS, null, null, R.mipmap.type_sniper_heavyshooter, R.mipmap.class_sniper));
        recruitableOperators.add(new RecruitableOperator("Ch'en", ATTACK_TYPE_MELEE, QUALIFICATION_TOP, 6, TYPE_GUARD_SWORDMASTER, CLASS_GUARD, AFFIX_DPS, AFFIX_NUKER, null, R.mipmap.type_guard_swordmaster, R.mipmap.class_guard));
        recruitableOperators.add(new RecruitableOperator("Skadi", ATTACK_TYPE_MELEE, QUALIFICATION_TOP, 6, TYPE_GUARD_DREADNOUGHT, CLASS_GUARD, AFFIX_DPS, AFFIX_SURVIVAL, null, R.mipmap.type_guard_dreadnought, R.mipmap.class_guard));
        recruitableOperators.add(new RecruitableOperator("SilverAsh", ATTACK_TYPE_MELEE, QUALIFICATION_TOP, 6, TYPE_GUARD_LORD, CLASS_GUARD, AFFIX_DPS, AFFIX_SUPPORT, null, R.mipmap.type_guard_lord, R.mipmap.class_guard));
        recruitableOperators.add(new RecruitableOperator("Saria", ATTACK_TYPE_MELEE, QUALIFICATION_TOP, 6, TYPE_DEFENDER_GUARDIAN, CLASS_DEFENDER, AFFIX_HEALING, AFFIX_DEFENSE, AFFIX_SUPPORT, R.mipmap.type_defender_guardian, R.mipmap.class_defender));
        recruitableOperators.add(new RecruitableOperator("Hoshiguma", ATTACK_TYPE_MELEE, QUALIFICATION_TOP, 6, TYPE_DEFENDER_PROTECTOR, CLASS_DEFENDER, AFFIX_DPS, AFFIX_DEFENSE, null, R.mipmap.type_defender_protector, R.mipmap.class_defender));
        recruitableOperators.add(new RecruitableOperator("Nightingale", ATTACK_TYPE_RANGED, QUALIFICATION_TOP, 6, TYPE_MEDIC_MULTITARGET, CLASS_MEDIC, AFFIX_HEALING, AFFIX_SUPPORT, null, R.mipmap.type_medic_multitarget, R.mipmap.class_medic));
        recruitableOperators.add(new RecruitableOperator("Shining", ATTACK_TYPE_RANGED, QUALIFICATION_TOP, 6, TYPE_MEDIC_ST, CLASS_MEDIC, AFFIX_HEALING, AFFIX_SUPPORT, null, R.mipmap.type_medic_st, R.mipmap.class_medic));
        recruitableOperators.add(new RecruitableOperator("Ifrit", ATTACK_TYPE_RANGED, QUALIFICATION_TOP, 6, TYPE_CASTER_BLAST, CLASS_CASTER, AFFIX_AOE, AFFIX_DEBUFF, null, R.mipmap.type_caster_blast, R.mipmap.class_caster));
        recruitableOperators.add(new RecruitableOperator("Siege", ATTACK_TYPE_MELEE, QUALIFICATION_TOP, 6, TYPE_VANGUARD_PIONEER, CLASS_VANGUARD, AFFIX_DPS, AFFIX_DP_RECOVERY, null, R.mipmap.type_vanguard_pioneer, R.mipmap.class_vanguard));
        recruitableOperators.add(new RecruitableOperator("Exusiai", ATTACK_TYPE_RANGED, QUALIFICATION_TOP, 6, TYPE_SNIPER_MARKSMAN, CLASS_SNIPER, AFFIX_DPS, null, null, R.mipmap.type_sniper_marksman, R.mipmap.class_sniper));
        recruitableOperators.add(new RecruitableOperator("Blaze", ATTACK_TYPE_MELEE, QUALIFICATION_TOP, 6, TYPE_GUARD_CENTURION, CLASS_GUARD, AFFIX_DPS, AFFIX_SURVIVAL, null, R.mipmap.type_guard_centurion, R.mipmap.class_guard));
    }
}


