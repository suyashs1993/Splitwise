package factory;

import enums.SplitType;

public class SplitMethodFactory {

    public SplitMethod getSplitMethod(SplitType splitType){
        if(splitType.equals(SplitType.EQUAL)){
            return new EqualSplitMethod();
        }
        if(splitType.equals(SplitType.EXACT)){
            return new ExactSplitMethod();
        }
        if(splitType.equals(SplitType.PERCENT)){
            return new PercentSplitMethod();
        }
        return null;
    }
}
