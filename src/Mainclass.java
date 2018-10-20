class MainClass {
    /*
     * Assuming that a two column array containing the relation and a one column          * array containing the set the relation is on is given in each method.
     * No checks are performed.
     */

    public static boolean isReflexive(char[][] relation, char [] set){
        int chars = set.length;
        int symetricChars = 0;
        for(char c : set) {
            for(int i = 0; i < relation.length; i++) {
                if(c == relation[i][0])
                    symetricChars += c == relation[i][1] ? 1 : 0;
            }
        }
        return chars == symetricChars;
    }

    public static boolean isSymmetric(char[][] relation, char [] set){
        for(int i = 0; i < relation.length; i++) {
            boolean sym = false;
            for(int j = 0; j < relation.length; j++) {
                if(relation[i][0] == relation[j][1] && relation[j][0] == relation[i][1])
                    sym = true;
            }
            if(!sym)
                return false;
        }
        return true;
    }

    public static boolean isTransitive(char[][] relation, char [] set){
        for(int i = 0; i < relation.length; i++) {
            for(int j = 0; j < relation.length; j++) {
                if(relation[i][0] != relation[i][1] && relation[i][1] == relation[j][0] && relation[i][0] != relation[j][0]) {
                    boolean trans = false;
                    for(int g = 0; g < relation.length; g++) {
                        if(relation[i][0] == relation[g][0] && relation[j][1] == relation[g][1])
                            trans = true;
                    }
                    if(!trans)
                        return false;
                }
            }
        }
        return true;
    }

    public static boolean isAntiSymmetric(char[][] relation, char [] set){
        for(int i = 0; i < relation.length; i++) {
            for(int j = i; j < relation.length; j++) {
                if(relation[i][0] != relation[i][1] && relation[i][0] == relation[j][1] && relation[i][1] == relation[j][0] )
                    return false;
            }
        }
        return true;
    }

    public static boolean isEquivalenceRelation(char[][] relation, char [] set){
        return (isReflexive(relation, set) && isSymmetric(relation, set) && isTransitive(relation, set));
    }

    public static boolean isPartialOrder(char[][] relation, char [] set){
        return (isReflexive(relation, set) && isAntiSymmetric(relation, set) && isTransitive(relation, set));
    }

    public static void main(String[] args) {
        char[] setA = {'a','x','r','m','2','0'};
        char[][] rel1 = {{'a','a'},{'r','a'},{'a','2'},{'x','x'},{'r','2'},{'r','r'},{'m','m'},{'2','r'},{'0','0'},{'a','r'},{'2','2'},{'2','a'}}; //Transitive = true
        char[][] rel2 = {{'a','x'},{'r','2'},{'0','0'},{'m','2'}};
        System.out.println("Rel1 is reflexive: " + isReflexive(rel1, setA));
        System.out.println("Rel2 is reflexive: " + isReflexive(rel2, setA));
        System.out.println("Rel1 is symmetric: " + isSymmetric(rel1, setA));
        System.out.println("Rel2 is symmetric: " + isSymmetric(rel2, setA));
        System.out.println("Rel1 is transitive: " + isTransitive(rel1, setA));
        System.out.println("Rel2 is transitive: " + isTransitive(rel2, setA));
        System.out.println("Rel1 is antisymmetric: " + isAntiSymmetric(rel1, setA));
        System.out.println("Rel2 is antisymmetric: " + isAntiSymmetric(rel2, setA));
        System.out.println("Rel1 is an equivalence relation: " + isEquivalenceRelation(rel1, setA));
        System.out.println("Rel2 is an equivalence relation: " + isEquivalenceRelation(rel2, setA));
        System.out.println("Rel1 is a partial order: " + isPartialOrder(rel1, setA));
        System.out.println("Rel2 is a partial order: " + isPartialOrder(rel2, setA));
	/* skal gi følgende utskrift:
	   Rel1 is reflexive: true
	   Rel2 is reflexive: false
	   Rel1 is symmetric: true
	   Rel2 is symmetric: false
	   Rel1 is transitive: true
	   Rel2 is transitive: true
	   Rel1 is antisymmetric: false
	   Rel2 is antisymmetric: true
	   Rel1 is an equivalence relation: true
	   Rel2 is an equivalence relation: false
	   Rel1 is a partial order: false
	   Rel2 is a partial order: false
	 */
    }


}