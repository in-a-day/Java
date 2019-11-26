package club.margay.git;

/**
 * 使用策略模式避免了switch
 * 枚举中的switch适用于给外部的枚举类型添加特定于常量的行为
 */
public enum PayrollDay {
    // strategy enum pattern
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY,
    SATURDAY(PayType.WEEKEND), SUNDAY(PayType.WEEKEND);

    private final PayType payType;

    PayrollDay() {
        payType = PayType.WEEKDAY;
    }
    PayrollDay(PayType payType) {
        this.payType = payType;
    }

    int pay(int minutesWorked, int payRate) {
        return payType.pay(minutesWorked, payRate);
    }

    // strategy enum type
    private enum PayType {
        WEEKEND {
            @Override
            int overtimePay(int minus, int payRate) {
                return minus <= MINUS_PER_SHIFT ? 0 :
                        (minus - MINUS_PER_SHIFT) * payRate / 2;
            }
        },
        WEEKDAY {
            @Override
            int overtimePay(int minus, int payRate) {
                return minus * payRate / 2;
            }
        };

        private static final int MINUS_PER_SHIFT = 8 * 60;
        abstract int overtimePay(int minus, int payRate);

        int pay(int minutesWorked, int payRate) {
            int basePay = minutesWorked * payRate;
            return basePay + overtimePay(minutesWorked, payRate);
        }
    }
}