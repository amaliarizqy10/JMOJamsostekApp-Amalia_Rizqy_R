package id.indocyber.api_service.usecase

import kotlinx.coroutines.flow.flow

class ProgramUseCase {
    operator fun invoke() = flow {
        val programList = arrayListOf("Jaminan Hari Tua", "Jaminan Kecelakaan Kerja", "Jaminan Kematian",
        "Jaminan Pensiun", "Jaminan Kehilangan Pekerjaan")
        emit(programList)
    }
}