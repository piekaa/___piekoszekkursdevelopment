class SumResult {

    public final int odd;
    public final int even;

    SumResult(int odd, int even) {
        this.odd = odd;
        this.even = even;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SumResult sumResult = (SumResult) o;

        if (odd != sumResult.odd) return false;
        return even == sumResult.even;
    }

    @Override
    public int hashCode() {
        int result = odd;
        result = 31 * result + even;
        return result;
    }

    @Override
    public String toString() {
        return "(%d, %d)".formatted(odd, even);
    }
}
