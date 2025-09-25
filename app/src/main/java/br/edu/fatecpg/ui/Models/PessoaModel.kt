import android.os.Parcel
import android.os.Parcelable

data class PessoaModel(
    val nome: String,
    val telefone: String,
    val imagemUrl: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: ""
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nome)
        parcel.writeString(telefone)
        parcel.writeString(imagemUrl)
    }

    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<PessoaModel> {
        override fun createFromParcel(parcel: Parcel): PessoaModel {
            return PessoaModel(parcel)
        }

        override fun newArray(size: Int): Array<PessoaModel?> {
            return arrayOfNulls(size)
        }
    }
}
