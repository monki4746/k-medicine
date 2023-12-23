package org.techtown.K_medicine;

public class CustomListForm {
    String order_number;  // 거래 번호
    String supplier;      // 인계사
    String receiver;      // 인수사
    String items_info_summary;  // 물품 정보

    public CustomListForm(String order_number, String supplier, String receiver, String items_info_summary) {
        this.order_number = order_number;
        this.supplier = supplier;
        this.receiver =  receiver;
        this.items_info_summary = items_info_summary;
    }

    public String getOrder_number() { return order_number; }

    public String getSupplier() { return supplier; }

    public String getReceiver() { return receiver; }

    public String getItems_info_summary() { return items_info_summary; }

    @Override
    public String toString() {
        return "거래 번호  : " + order_number + '\n' +
                "인계사    : " + supplier + '\n' +
                "인수사    : " + receiver + '\n' +
                "물품 정보 : " + items_info_summary;
    }
}