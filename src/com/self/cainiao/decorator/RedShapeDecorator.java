package com.self.cainiao.decorator;

public class RedShapeDecorator extends ShapeDecorator {
    public RedShapeDecorator(Shape decoratedShape) {
        super(decoratedShape);
    }

    @Override
    public void draw() {
        decoratedShape.draw();
        setDecoratedShape(decoratedShape);
    }
    private void setDecoratedShape(Shape decoratedShape) {
        System.out.println("Border Color:Red");
    }
}
