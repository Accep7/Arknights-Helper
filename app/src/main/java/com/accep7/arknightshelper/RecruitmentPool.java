package com.accep7.arknightshelper;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class RecruitmentPool {
    //region Filtering parameters. Serves as predicates for buttons and as Operator properties.
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
        final String inGameClass;
        final String affix1;
        final String affix2;
        final String affix3;
        //Used for showing expandable operator details in list.
        //sadsadas

        RecruitableOperator(String operatorName, String attackType, String qualification, int rarity, String inGameClass, String affix1, String affix2, String affix3) {
            this.operatorName = operatorName;
            this.attackType = attackType;
            this.qualification = qualification;
            this.rarity = rarity;
            this.inGameClass = inGameClass;
            this.affix1 = affix1;
            this.affix2 = affix2;
            this.affix3 = affix3;
        }

        @Override
        @NonNull
        public String toString() {
            return "RecruitableOperator{" +
                    "name='" + operatorName + '\'' +
                    ", attackType='" + attackType + '\'' +
                    ", qualification='" + qualification + '\'' +
                    ", rarity=" + rarity +
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
            return rarity == that.rarity && Objects.equals(operatorName, that.operatorName) && Objects.equals(attackType, that.attackType) && Objects.equals(qualification, that.qualification) && Objects.equals(inGameClass, that.inGameClass) && Objects.equals(affix1, that.affix1) && Objects.equals(affix2, that.affix2) && Objects.equals(affix3, that.affix3);
        }

        @Override
        public int hashCode() {
            return Objects.hash(operatorName, attackType, qualification, rarity, inGameClass, affix1, affix2, affix3);
        }
    }

    /* The RecruitmentPool ArrayList, that contains all of the current global server operators in recruitment pool.
     * When in-game recruitment pool updates, simply add a new RecruitableOperator to this ArrayList and assign its in-game attributes */
    static List<RecruitableOperator> recruitableOperators = new ArrayList<>();

    static {
        //1-star rarity
        recruitableOperators.add(new RecruitableOperator("Lancet-2", ATTACK_TYPE_RANGED, null, 1, CLASS_MEDIC, AFFIX_HEALING, AFFIX_ROBOT, null));
        recruitableOperators.add(new RecruitableOperator("Castle-3", ATTACK_TYPE_MELEE, null, 1, CLASS_GUARD, AFFIX_SUPPORT, AFFIX_ROBOT, null));
        recruitableOperators.add(new RecruitableOperator("THRM-EX", ATTACK_TYPE_MELEE, null, 1, CLASS_SPECIALIST, AFFIX_NUKER, AFFIX_ROBOT, null));

        //2-star rarity
        recruitableOperators.add(new RecruitableOperator("Durin", ATTACK_TYPE_RANGED, QUALIFICATION_STARTER, 2, CLASS_CASTER, null, null, null));
        recruitableOperators.add(new RecruitableOperator("12F", ATTACK_TYPE_RANGED, QUALIFICATION_STARTER, 2, CLASS_CASTER, null, null, null));
        recruitableOperators.add(new RecruitableOperator("Rangers", ATTACK_TYPE_RANGED, QUALIFICATION_STARTER, 2, CLASS_SNIPER, null, null, null));
        recruitableOperators.add(new RecruitableOperator("Yato", ATTACK_TYPE_MELEE, QUALIFICATION_STARTER, 2, CLASS_VANGUARD, null, null, null));
        recruitableOperators.add(new RecruitableOperator("Noir Corne", ATTACK_TYPE_MELEE, QUALIFICATION_STARTER, 2, CLASS_DEFENDER, null, null, null));

        //3-star rarity
        recruitableOperators.add(new RecruitableOperator("Spot", ATTACK_TYPE_MELEE, null, 3, CLASS_DEFENDER, AFFIX_HEALING, AFFIX_DEFENSE, null));
        recruitableOperators.add(new RecruitableOperator("Beagle", ATTACK_TYPE_MELEE, null, 3, CLASS_DEFENDER, AFFIX_DEFENSE, null, null));
        recruitableOperators.add(new RecruitableOperator("Popukar", ATTACK_TYPE_MELEE, null, 3, CLASS_GUARD, AFFIX_AOE, AFFIX_SURVIVAL, null));
        recruitableOperators.add(new RecruitableOperator("Midnight", ATTACK_TYPE_MELEE, null, 3, CLASS_GUARD, AFFIX_DPS, null, null));
        recruitableOperators.add(new RecruitableOperator("Melantha", ATTACK_TYPE_MELEE, null, 3, CLASS_GUARD, AFFIX_DPS, AFFIX_SURVIVAL, null));
        recruitableOperators.add(new RecruitableOperator("Plume", ATTACK_TYPE_MELEE, null, 3, CLASS_VANGUARD, AFFIX_DPS, AFFIX_DP_RECOVERY, null));
        recruitableOperators.add(new RecruitableOperator("Vanilla", ATTACK_TYPE_MELEE, null, 3, CLASS_VANGUARD, AFFIX_DP_RECOVERY, null, null));
        recruitableOperators.add(new RecruitableOperator("Fang", ATTACK_TYPE_MELEE, null, 3, CLASS_VANGUARD, AFFIX_DP_RECOVERY, null, null));
        recruitableOperators.add(new RecruitableOperator("Catapult", ATTACK_TYPE_RANGED, null, 3, CLASS_SNIPER, AFFIX_AOE, null, null));
        recruitableOperators.add(new RecruitableOperator("Adnachiel", ATTACK_TYPE_RANGED, null, 3, CLASS_SNIPER, AFFIX_DPS, null, null));
        recruitableOperators.add(new RecruitableOperator("Kroos", ATTACK_TYPE_RANGED, null, 3, CLASS_SNIPER, AFFIX_DPS, null, null));
        recruitableOperators.add(new RecruitableOperator("Orchid", ATTACK_TYPE_RANGED, null, 3, CLASS_SUPPORTER, AFFIX_SLOW, null, null));
        recruitableOperators.add(new RecruitableOperator("Steward", ATTACK_TYPE_RANGED, null, 3, CLASS_CASTER, AFFIX_DPS, null, null));
        recruitableOperators.add(new RecruitableOperator("Lava", ATTACK_TYPE_RANGED, null, 3, CLASS_CASTER, AFFIX_AOE, null, null));
        recruitableOperators.add(new RecruitableOperator("Hibiscus", ATTACK_TYPE_RANGED, null, 3, CLASS_MEDIC, AFFIX_HEALING, null, null));
        recruitableOperators.add(new RecruitableOperator("Ansel", ATTACK_TYPE_RANGED, null, 3, CLASS_MEDIC, AFFIX_HEALING, null, null));

        //4-star rarity
        recruitableOperators.add(new RecruitableOperator("Myrtle", ATTACK_TYPE_MELEE, null, 4, CLASS_VANGUARD, AFFIX_DP_RECOVERY, AFFIX_HEALING, null));
        recruitableOperators.add(new RecruitableOperator("Vigna", ATTACK_TYPE_MELEE, null, 4, CLASS_VANGUARD, AFFIX_DPS, AFFIX_DP_RECOVERY, null));
        recruitableOperators.add(new RecruitableOperator("Scavenger", ATTACK_TYPE_MELEE, null, 4, CLASS_VANGUARD, AFFIX_DPS, AFFIX_DP_RECOVERY, null));
        recruitableOperators.add(new RecruitableOperator("Shaw", ATTACK_TYPE_MELEE, null, 4, CLASS_SPECIALIST, AFFIX_SHIFT, null, null));
        recruitableOperators.add(new RecruitableOperator("Rope", ATTACK_TYPE_MELEE, null, 4, CLASS_SPECIALIST, AFFIX_SHIFT, null, null));
        recruitableOperators.add(new RecruitableOperator("Gravel", ATTACK_TYPE_MELEE, null, 4, CLASS_SPECIALIST, AFFIX_DEFENSE, AFFIX_FAST_REDEPLOY, null));
        recruitableOperators.add(new RecruitableOperator("Gummy", ATTACK_TYPE_MELEE, null, 4, CLASS_DEFENDER, AFFIX_DEFENSE, AFFIX_HEALING, null));
        recruitableOperators.add(new RecruitableOperator("Cuora", ATTACK_TYPE_MELEE, null, 4, CLASS_DEFENDER, AFFIX_DEFENSE, null, null));
        recruitableOperators.add(new RecruitableOperator("Matterhorn", ATTACK_TYPE_MELEE, null, 4, CLASS_DEFENDER, AFFIX_DEFENSE, null, null));
        recruitableOperators.add(new RecruitableOperator("Beehunter", ATTACK_TYPE_MELEE, null, 4, CLASS_GUARD, AFFIX_DPS, null, null));
        recruitableOperators.add(new RecruitableOperator("Mousse", ATTACK_TYPE_MELEE, null, 4, CLASS_GUARD, AFFIX_DPS, null, null));
        recruitableOperators.add(new RecruitableOperator("Estelle", ATTACK_TYPE_MELEE, null, 4, CLASS_GUARD, AFFIX_AOE, AFFIX_SURVIVAL, null));
        recruitableOperators.add(new RecruitableOperator("Frostleaf", ATTACK_TYPE_MELEE, null, 4, CLASS_GUARD, AFFIX_DPS, AFFIX_SLOW, null));
        recruitableOperators.add(new RecruitableOperator("Matoimaru", ATTACK_TYPE_MELEE, null, 4, CLASS_GUARD, AFFIX_DPS, AFFIX_SURVIVAL, null));
        recruitableOperators.add(new RecruitableOperator("Dobermann", ATTACK_TYPE_MELEE, null, 4, CLASS_GUARD, AFFIX_DPS, AFFIX_SUPPORT, null));
        recruitableOperators.add(new RecruitableOperator("Vermeil", ATTACK_TYPE_RANGED, null, 4, CLASS_SNIPER, AFFIX_DPS, null, null));
        recruitableOperators.add(new RecruitableOperator("Shirayuki", ATTACK_TYPE_RANGED, null, 4, CLASS_SNIPER, AFFIX_AOE, AFFIX_SLOW, null));
        recruitableOperators.add(new RecruitableOperator("Meteor", ATTACK_TYPE_RANGED, null, 4, CLASS_SNIPER, AFFIX_DPS, AFFIX_DEBUFF, null));
        recruitableOperators.add(new RecruitableOperator("Jessica", ATTACK_TYPE_RANGED, null, 4, CLASS_SNIPER, AFFIX_DPS, AFFIX_SURVIVAL, null));
        recruitableOperators.add(new RecruitableOperator("Sussuro", ATTACK_TYPE_RANGED, null, 4, CLASS_MEDIC, AFFIX_HEALING, null, null));
        recruitableOperators.add(new RecruitableOperator("Perfumer", ATTACK_TYPE_RANGED, null, 4, CLASS_MEDIC, AFFIX_HEALING, null, null));
        recruitableOperators.add(new RecruitableOperator("Myrrh", ATTACK_TYPE_RANGED, null, 4, CLASS_MEDIC, AFFIX_HEALING, null, null));
        recruitableOperators.add(new RecruitableOperator("Greyy", ATTACK_TYPE_RANGED, null, 4, CLASS_CASTER, AFFIX_AOE, AFFIX_SLOW, null));
        recruitableOperators.add(new RecruitableOperator("Gitano", ATTACK_TYPE_RANGED, null, 4, CLASS_CASTER, AFFIX_AOE, null, null));
        recruitableOperators.add(new RecruitableOperator("Haze", ATTACK_TYPE_RANGED, null, 4, CLASS_CASTER, AFFIX_DPS, AFFIX_DEBUFF, null));
        recruitableOperators.add(new RecruitableOperator("Earthspirit", ATTACK_TYPE_RANGED, null, 4, CLASS_SUPPORTER, AFFIX_SLOW, null, null));
        recruitableOperators.add(new RecruitableOperator("May", ATTACK_TYPE_RANGED, null, 4, CLASS_SNIPER, AFFIX_DPS, AFFIX_SLOW, null));

        //5-star rarity
        recruitableOperators.add(new RecruitableOperator("Astesia", ATTACK_TYPE_MELEE, QUALIFICATION_SENIOR, 5, CLASS_GUARD, AFFIX_DPS, AFFIX_DEFENSE, null));
        recruitableOperators.add(new RecruitableOperator("Swire", ATTACK_TYPE_MELEE, QUALIFICATION_SENIOR, 5, CLASS_GUARD, AFFIX_DPS, AFFIX_SUPPORT, null));
        recruitableOperators.add(new RecruitableOperator("Specter", ATTACK_TYPE_MELEE, QUALIFICATION_SENIOR, 5, CLASS_GUARD, AFFIX_AOE, AFFIX_SURVIVAL, null));
        recruitableOperators.add(new RecruitableOperator("Indra", ATTACK_TYPE_MELEE, QUALIFICATION_SENIOR, 5, CLASS_GUARD, AFFIX_DPS, AFFIX_SURVIVAL, null));
        recruitableOperators.add(new RecruitableOperator("FEater", ATTACK_TYPE_MELEE, QUALIFICATION_SENIOR, 5, CLASS_SPECIALIST, AFFIX_SHIFT, AFFIX_SLOW, null));
        recruitableOperators.add(new RecruitableOperator("Cliffheart", ATTACK_TYPE_MELEE, QUALIFICATION_SENIOR, 5, CLASS_SPECIALIST, AFFIX_SHIFT, AFFIX_DPS, null));
        recruitableOperators.add(new RecruitableOperator("Manticore", ATTACK_TYPE_MELEE, QUALIFICATION_SENIOR, 5, CLASS_SPECIALIST, AFFIX_DPS, AFFIX_SURVIVAL, null));
        recruitableOperators.add(new RecruitableOperator("Projekt Red", ATTACK_TYPE_MELEE, QUALIFICATION_SENIOR, 5, CLASS_SPECIALIST, AFFIX_FAST_REDEPLOY, AFFIX_CROWD_CONTROL, null));
        recruitableOperators.add(new RecruitableOperator("Vulcan", ATTACK_TYPE_MELEE, QUALIFICATION_SENIOR, 5, CLASS_DEFENDER, AFFIX_DPS, AFFIX_SURVIVAL, AFFIX_DEFENSE));
        recruitableOperators.add(new RecruitableOperator("Croissant", ATTACK_TYPE_MELEE, QUALIFICATION_SENIOR, 5, CLASS_DEFENDER, AFFIX_DEFENSE, AFFIX_SHIFT, null));
        recruitableOperators.add(new RecruitableOperator("Liskarm", ATTACK_TYPE_MELEE, QUALIFICATION_SENIOR, 5, CLASS_DEFENDER, AFFIX_DEFENSE, AFFIX_DPS, null));
        recruitableOperators.add(new RecruitableOperator("Nearl", ATTACK_TYPE_MELEE, QUALIFICATION_SENIOR, 5, CLASS_DEFENDER, AFFIX_HEALING, AFFIX_DEFENSE, null));
        recruitableOperators.add(new RecruitableOperator("Texas", ATTACK_TYPE_MELEE, QUALIFICATION_SENIOR, 5, CLASS_VANGUARD, AFFIX_DP_RECOVERY, AFFIX_CROWD_CONTROL, null));
        recruitableOperators.add(new RecruitableOperator("Zima", ATTACK_TYPE_MELEE, QUALIFICATION_SENIOR, 5, CLASS_VANGUARD, AFFIX_DP_RECOVERY, AFFIX_SUPPORT, null));
        recruitableOperators.add(new RecruitableOperator("Waai Fu", ATTACK_TYPE_MELEE, QUALIFICATION_SENIOR, 5, CLASS_SPECIALIST, AFFIX_FAST_REDEPLOY, AFFIX_DEBUFF, null));
        recruitableOperators.add(new RecruitableOperator("Executor", ATTACK_TYPE_RANGED, QUALIFICATION_SENIOR, 5, CLASS_SNIPER, AFFIX_AOE, null, null));
        recruitableOperators.add(new RecruitableOperator("Meteorite", ATTACK_TYPE_RANGED, QUALIFICATION_SENIOR, 5, CLASS_SNIPER, AFFIX_AOE, AFFIX_DEBUFF, null));
        recruitableOperators.add(new RecruitableOperator("Platinum", ATTACK_TYPE_RANGED, QUALIFICATION_SENIOR, 5, CLASS_SNIPER, AFFIX_DPS, null, null));
        recruitableOperators.add(new RecruitableOperator("Blue Poison", ATTACK_TYPE_RANGED, QUALIFICATION_SENIOR, 5, CLASS_SNIPER, AFFIX_DPS, null, null));
        recruitableOperators.add(new RecruitableOperator("Firewatch", ATTACK_TYPE_RANGED, QUALIFICATION_SENIOR, 5, CLASS_SNIPER, AFFIX_NUKER, AFFIX_DPS, null));
        recruitableOperators.add(new RecruitableOperator("Provence", ATTACK_TYPE_RANGED, QUALIFICATION_SENIOR, 5, CLASS_SNIPER, AFFIX_DPS, null, null));
        recruitableOperators.add(new RecruitableOperator("Glaucus", ATTACK_TYPE_RANGED, QUALIFICATION_SENIOR, 5, CLASS_SUPPORTER, AFFIX_CROWD_CONTROL, AFFIX_SLOW, null));
        recruitableOperators.add(new RecruitableOperator("Mayer", ATTACK_TYPE_RANGED, QUALIFICATION_SENIOR, 5, CLASS_SUPPORTER, AFFIX_CROWD_CONTROL, AFFIX_SUMMON, null));
        recruitableOperators.add(new RecruitableOperator("Istina", ATTACK_TYPE_RANGED, QUALIFICATION_SENIOR, 5, CLASS_SUPPORTER, AFFIX_DPS, AFFIX_SLOW, null));
        recruitableOperators.add(new RecruitableOperator("Pramanix", ATTACK_TYPE_RANGED, QUALIFICATION_SENIOR, 5, CLASS_SUPPORTER, AFFIX_DEBUFF, null, null));
        recruitableOperators.add(new RecruitableOperator("Nightmare", ATTACK_TYPE_RANGED, QUALIFICATION_SENIOR, 5, CLASS_CASTER, AFFIX_DPS, AFFIX_SLOW, AFFIX_HEALING));
        recruitableOperators.add(new RecruitableOperator("Warfarin", ATTACK_TYPE_RANGED, QUALIFICATION_SENIOR, 5, CLASS_MEDIC, AFFIX_HEALING, AFFIX_SUPPORT, null));
        recruitableOperators.add(new RecruitableOperator("Ptilopsis", ATTACK_TYPE_RANGED, QUALIFICATION_SENIOR, 5, CLASS_MEDIC, AFFIX_HEALING, AFFIX_SUPPORT, null));
        recruitableOperators.add(new RecruitableOperator("Silence", ATTACK_TYPE_RANGED, QUALIFICATION_SENIOR, 5, CLASS_MEDIC, AFFIX_HEALING, null, null));

        //6-star rarity
        recruitableOperators.add(new RecruitableOperator("Siege", ATTACK_TYPE_MELEE, QUALIFICATION_TOP, 6, CLASS_VANGUARD, AFFIX_DPS, AFFIX_DP_RECOVERY, null));
        recruitableOperators.add(new RecruitableOperator("Hoshiguma", ATTACK_TYPE_MELEE, QUALIFICATION_TOP, 6, CLASS_DEFENDER, AFFIX_DPS, AFFIX_DEFENSE, null));
        recruitableOperators.add(new RecruitableOperator("Saria", ATTACK_TYPE_MELEE, QUALIFICATION_TOP, 6, CLASS_DEFENDER, AFFIX_HEALING, AFFIX_DEFENSE, AFFIX_SUPPORT));
        recruitableOperators.add(new RecruitableOperator("SilverAsh", ATTACK_TYPE_MELEE, QUALIFICATION_TOP, 6, CLASS_GUARD, AFFIX_DPS, AFFIX_SUPPORT, null));
        recruitableOperators.add(new RecruitableOperator("Skadi", ATTACK_TYPE_MELEE, QUALIFICATION_TOP, 6, CLASS_GUARD, AFFIX_DPS, AFFIX_SURVIVAL, null));
        recruitableOperators.add(new RecruitableOperator("Hellagur", ATTACK_TYPE_MELEE, QUALIFICATION_TOP, 6, CLASS_GUARD, AFFIX_DPS, AFFIX_SURVIVAL, null));
        recruitableOperators.add(new RecruitableOperator("Ch'en", ATTACK_TYPE_MELEE, QUALIFICATION_TOP, 6, CLASS_GUARD, AFFIX_DPS, AFFIX_NUKER, null));
        recruitableOperators.add(new RecruitableOperator("Magallan", ATTACK_TYPE_RANGED, QUALIFICATION_TOP, 6, CLASS_SUPPORTER, AFFIX_SLOW, AFFIX_SUPPORT, AFFIX_DPS));
        recruitableOperators.add(new RecruitableOperator("Schwarz", ATTACK_TYPE_RANGED, QUALIFICATION_TOP, 6, CLASS_SNIPER, AFFIX_DPS, null, null));
        recruitableOperators.add(new RecruitableOperator("Exusiai", ATTACK_TYPE_RANGED, QUALIFICATION_TOP, 6, CLASS_SNIPER, AFFIX_DPS, null, null));
        recruitableOperators.add(new RecruitableOperator("Ifrit", ATTACK_TYPE_RANGED, QUALIFICATION_TOP, 6, CLASS_CASTER, AFFIX_AOE, AFFIX_DEBUFF, null));
        recruitableOperators.add(new RecruitableOperator("Shining", ATTACK_TYPE_RANGED, QUALIFICATION_TOP, 6, CLASS_MEDIC, AFFIX_HEALING, AFFIX_SUPPORT, null));
        recruitableOperators.add(new RecruitableOperator("Nightingale", ATTACK_TYPE_RANGED, QUALIFICATION_TOP, 6, CLASS_MEDIC, AFFIX_HEALING, AFFIX_SUPPORT, null));
        recruitableOperators.add(new RecruitableOperator("Mostima", ATTACK_TYPE_RANGED, QUALIFICATION_TOP, 6, CLASS_CASTER, AFFIX_AOE, AFFIX_SUPPORT, AFFIX_CROWD_CONTROL));
    }
}


