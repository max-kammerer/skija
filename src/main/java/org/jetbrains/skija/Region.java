package org.jetbrains.skija;

public class Region extends Managed {
    public enum Op { DIFFERENCE, INTERSECT, UNION, XOR, REVERSE_DIFFERENCE, REPLACE }

    public Region() { super(nInit(), nativeFinalizer); Native.onNativeCall(); }

    public boolean set(Region r) { Native.onNativeCall(); return nSet(nativeInstance, r.nativeInstance); }
    public boolean isEmpty() { Native.onNativeCall(); return nIsEmpty(nativeInstance); }
    public boolean isRect() { Native.onNativeCall(); return nIsRect(nativeInstance); }
    public boolean isComplex() { Native.onNativeCall(); return nIsComplex(nativeInstance); }
    public int[]   getBounds() { Native.onNativeCall(); return nGetBounds(nativeInstance); }
    public int     computeRegionComplexity() { Native.onNativeCall(); return nComputeRegionComplexity(nativeInstance); }
    public boolean getBoundaryPath(Path p) { Native.onNativeCall(); return nGetBoundaryPath(nativeInstance, p.nativeInstance); }
    public boolean setEmpty() { Native.onNativeCall(); return nSetEmpty(nativeInstance); }
    public boolean setRect(int left, int top, int right, int bottom) { Native.onNativeCall(); return nSetRect(nativeInstance, left, top, right, bottom); }
    public boolean setRects(int[] rects) {
        assert rects.length > 0 && rects.length % 4 == 0 : "Expected array length divisible by 4, got " + rects.length;
        Native.onNativeCall(); 
        return nSetRects(nativeInstance, rects);
    }
    public boolean setRegion(Region r) { Native.onNativeCall(); return nSetRegion(nativeInstance, r.nativeInstance); }
    public boolean setPath(Path path, Region clip) { Native.onNativeCall(); return nSetPath(nativeInstance, path.nativeInstance, clip.nativeInstance); }
    public boolean intersects(int left, int top, int right, int bottom) { Native.onNativeCall(); return nIntersectsIRect(nativeInstance, left, top, right, bottom); }
    public boolean intersects(Region r) { Native.onNativeCall(); return nIntersectsRegion(nativeInstance, r.nativeInstance); }
    public boolean contains(int x, int y) { Native.onNativeCall(); return nContainsIPoint(nativeInstance, x, y); }
    public boolean contains(int left, int top, int right, int bottom) { Native.onNativeCall(); return nContainsIRect(nativeInstance, left, top, right, bottom); }
    public boolean contains(Region r) { Native.onNativeCall(); return nContainsRegion(nativeInstance, r.nativeInstance); }
    public boolean quickContains(int left, int top, int right, int bottom) { Native.onNativeCall(); return nQuickContains(nativeInstance, left, top, right, bottom); }
    public boolean quickReject(int left, int top, int right, int bottom) { Native.onNativeCall(); return nQuickRejectIRect(nativeInstance, left, top, right, bottom); }
    public boolean quickReject(Region r) { Native.onNativeCall(); return nQuickRejectRegion(nativeInstance, r.nativeInstance); }
    public void    translate(int dx, int dy) { Native.onNativeCall(); nTranslate(nativeInstance, dx, dy); }
    public boolean op(int left, int top, int right, int bottom, Op op) { Native.onNativeCall(); return nOpIRect(nativeInstance, left, top, right, bottom, op.ordinal()); }
    public boolean op(Region r, Op op) { Native.onNativeCall(); return nOpRegion(nativeInstance, r.nativeInstance, op.ordinal()); }
    public boolean op(int left, int top, int right, int bottom, Region r, Op op) { Native.onNativeCall(); return nOpIRectRegion(nativeInstance, left, top, right, bottom, r.nativeInstance, op.ordinal()); }
    public boolean op(Region r, int left, int top, int right, int bottom, Op op) { Native.onNativeCall(); return nOpRegionIRect(nativeInstance, r.nativeInstance, left, top, right, bottom, op.ordinal()); }
    public boolean op(Region a, Region b, Op op) { Native.onNativeCall(); return nOpRegionRegion(nativeInstance, a.nativeInstance, b.nativeInstance, op.ordinal()); }

    private static final long nativeFinalizer = nGetNativeFinalizer();
    private static native long nInit();
    private static native long nGetNativeFinalizer();

    private static native boolean nSet(long ptr, long regoinPtr);
    private static native boolean nIsEmpty(long ptr);
    private static native boolean nIsRect(long ptr);
    private static native boolean nIsComplex(long ptr);
    private static native int[]   nGetBounds(long ptr);
    private static native int     nComputeRegionComplexity(long ptr);
    private static native boolean nGetBoundaryPath(long ptr, long pathPtr);
    private static native boolean nSetEmpty(long ptr);
    private static native boolean nSetRect(long ptr, int left, int top, int right, int bottom);
    private static native boolean nSetRects(long ptr, int[] rects);
    private static native boolean nSetRegion(long ptr, long regionPtr);
    private static native boolean nSetPath(long ptr, long pathPtr, long regionPtr);

    private static native boolean nIntersectsIRect(long ptr, int left, int top, int right, int bottom);
    private static native boolean nIntersectsRegion(long ptr, long regionPtr);
    private static native boolean nContainsIPoint(long ptr, int x, int y);
    private static native boolean nContainsIRect(long ptr, int left, int top, int right, int bottom);
    private static native boolean nContainsRegion(long ptr, long regionPtr);
    private static native boolean nQuickContains(long ptr, int left, int top, int right, int bottom);
    private static native boolean nQuickRejectIRect(long ptr, int left, int top, int right, int bottom);
    private static native boolean nQuickRejectRegion(long ptr, long regionPtr);
    private static native void    nTranslate(long ptr, int dx, int dy);
    private static native boolean nOpIRect(long ptr, int left, int top, int right, int bottom, int op);
    private static native boolean nOpRegion(long ptr, long regionPtr, int op);
    private static native boolean nOpIRectRegion(long ptr, int left, int top, int right, int bottom, long regionPtr, int op);
    private static native boolean nOpRegionIRect(long ptr, long regionPtr, int left, int top, int right, int bottom, int op);
    private static native boolean nOpRegionRegion(long ptr, long regionPtrA, long regionPtrB, int op);
}